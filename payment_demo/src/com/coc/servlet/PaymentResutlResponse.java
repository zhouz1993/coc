package com.coc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coc.utils.ConfigInfo;
import com.coc.utils.PanymentUtil;

/**
 * 响应银行支付结果请求
 * @author 
 */
public class PaymentResutlResponse extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 这里调用doPost方法
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String merchantID = ConfigInfo.getValue("p1_MerId"); // 商家ID
		String keyValue = ConfigInfo.getValue("keyValue"); // 商家密钥
		// 取得易宝支付返回的元数据
		String sCmd = request.getParameter("r0_Cmd"); // 业务类型
		String sResultCode = request.getParameter("r1_Code"); // 扣款结果,该字段值为1时表示扣款成功.
		String sTrxId = request.getParameter("r2_TrxId"); // YeePay易宝交易订单号
		String amount = request.getParameter("r3_Amt");// 扣款金额,交易结束后,YeePay易宝交易系统将实际扣款金额返回给商户
		String currency = request.getParameter("r4_Cur");// 交易币种,人民币为CNY
		String productId = request.getParameter("r5_Pid");// 商品ID
		String orderId = request.getParameter("r6_Order");// 商户订单号
		String userId = request.getParameter("r7_Uid");// YeePay易宝会员ID
		String mp = request.getParameter("r8_MP");// 商户扩展信息,可以任意填写1K
													// 的字符串,交易返回时将原样返回
		String bType = request.getParameter("r9_BType");// 交易结果通知类型,1:
														// 交易成功回调(浏览器重定向)2:
														// 交易成功主动通知(服务器点对点通讯)
		String rb_BankId = request.getParameter("rb_BankId");// 支付银行
		String rp_PayDate = request.getParameter("rp_PayDate");// 在银行支付时的时间
		// 取得md5加密后的字串.
		String hmac = request.getParameter("hmac");// MD5交易签名
		// 验证返回的数据是否合法
		boolean result = PanymentUtil.verifyCallback(hmac, merchantID, sCmd, sResultCode, sTrxId, amount, currency,
				productId, orderId, userId, mp, bType, keyValue);
		if (result) {
			if ("1".equals(sResultCode)) {// 如果为1说明,这时候易宝支付扣款成功.
				// 你们这个地方应该把数据库中订单的支付状态设置成已经支付.
				// 2.这里一定要注意:如果是游戏点卡的话
				// 那么这里只能增加一次,否则用户没刷新一次
				// 浏览器点卡就会增加一部分,这样是很危险的.
				String message = "订单号为:" + orderId + "的订单支付成功了";
				message += ",用户支付了" + amount + "元";
				message += ",交易结果通知类型:";
				if ("1".equals(bType)) {// 这里有两种类型,1为引导用户的浏览器重定向到url地址,
					// 这个是我们提供的.但是如果用户的网络有问题,或者
					// 浏览器有问题就会中途断掉,这种类型是不可靠的
					message += "浏览器重定向";
				} else if ("2".equals(bType)) {// 易宝支付主动的通知我们的地址,这两种类型是并行的.
					message += "易宝支付网关后台程序通知";
				}
				message += ",易宝订单系统中的订单号为:" + sTrxId;
				request.setAttribute("message", message);
			} else {
				request.setAttribute("message", "用户支付失败");
			}
		} else {
			request.setAttribute("message", "数据来源不合法");
		}
		request.getRequestDispatcher("/WEB-INF/page/paymentResult.jsp").forward(request, response);
	}
}