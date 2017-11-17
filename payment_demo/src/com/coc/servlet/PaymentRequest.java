package com.coc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coc.utils.ConfigInfo;
import com.coc.utils.PanymentUtil;

/**
 * 发起支付请求
 * @author
 *
 */
public class PaymentRequest extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * p1_MerId=10000326625         // 商家的id
		 * keyValue=0acqgug6x57m0wrsiod6clpn1ezh47r2ot5h1zkq5dztiic8y5xkm5g0p0ek       //密钥
		 * merchantCallbackURL=http\://localhost\:8080/payment/servlet/yeepay/response // // 这个地址是用来接收易宝支付返回结果的路径.这个路径必须外网可以访问.
		 */
		request.setCharacterEncoding("UTF-8");
		String orderid = request.getParameter("orderid");// 订单号
		String amount = request.getParameter("amount");// 支付金额
		String pd_FrpId = request.getParameter("pd_FrpId");// 选择的支付银行
		String p1_MerId = ConfigInfo.getValue("p1_MerId");
		String keyValue = ConfigInfo.getValue("keyValue");
		String merchantCallbackURL = ConfigInfo.getValue("merchantCallbackURL");
		String messageType = "Buy"; // 请求命令,在线支付固定为Buy
		String currency = "CNY"; // 货币单位
		String productDesc = ""; // 商品描述
		String productCat = ""; // 商品种类
		String productId = ""; // 商品ID
		String addressFlag = "0"; // 需要填写送货信息 0：不需要 1:需要
		String sMctProperties = ""; // 商家扩展信息
		String pr_NeedResponse = "0"; // 应答机制
		// 下面这个方法用来进行加密.通过调用加密类.
		String md5hmac = PanymentUtil.buildHmac(messageType, p1_MerId, orderid, amount, currency, productId, productCat,
				productDesc, merchantCallbackURL, addressFlag, sMctProperties, pd_FrpId, pr_NeedResponse, keyValue);
		// 1.注意这里是根据易宝支付的原理来的,商户需要把,一些支付信息,和加密后的支付信息,同时发给易宝支付
		// 易宝支付收到信息后,利用密钥进行对信息再次加密,拿自己加密后的信息和商户发过来的加密信息
		// 进行对比,对比结果为一致的时候,那么说明信息没有被串改过.
		// 得到加密后的字串.
		request.setAttribute("messageType", messageType);// 支付命令
		request.setAttribute("merchantID", p1_MerId);// 商户id
		request.setAttribute("orderId", orderid);// 订单号
		request.setAttribute("amount", amount);// 订单金额
		request.setAttribute("currency", currency);// 货币类型
		request.setAttribute("productId", productId);// 产品id
		request.setAttribute("productCat", productCat);// 产品种类
		request.setAttribute("productDesc", productDesc);// 商品描述
		request.setAttribute("merchantCallbackURL", merchantCallbackURL);// 返回的URL
		request.setAttribute("addressFlag", addressFlag);// 收货地址
		request.setAttribute("sMctProperties", sMctProperties);// 商家扩展信息
		request.setAttribute("frpId", pd_FrpId);// 银行id
		request.setAttribute("pr_NeedResponse", pr_NeedResponse);// 应答机制.
		request.setAttribute("hmac", md5hmac);// MD5验证码
		// 转发.
		request.getRequestDispatcher("/WEB-INF/page/connection.jsp").forward(request, response);
	}
}
