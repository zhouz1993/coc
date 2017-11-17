<%@ page language="java" contenttype="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCtype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<meta http-equiv="param" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>在线支付 -选择银行</title>
</head>
<body>
<table width="960" border="0" align="center">
	<tr>
		<td width="536" valign="top">
			<form action="${pageContext.request.contextPath}/servlet/yeepay/paymentRequest" method="post" name="paymentform">
				<table width="100%" border="0">
					<tr>
						<td height="30" colspan="4"><table width="100%" height="50" border="0" cellpadding="0" cellspacing="1" bgcolor="#A2E0FF">
					<tr>
						<td align="center" bgcolor="#F70EFF">
						<h3>订单号：<input type="text" name="orderid"> 应付金额：￥<input type="text" name="amount" size="5">元
						</h3></td></tr>
					</table></td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td height="30" colspan="4" bgcolor="#F4F800"><span
								class="STYLE3">请您选择在线支付银行</span></td>
						</tr>
						<tr>
							<td width="26%" height="25"><input type="radio"
								name="pd_FrpId" value="CMBCHINA-NET">招商银行</td>
							<td width="25%" height="25"><input type="radio"
								name="pd_FrpId" value="ICBC-NET">工商银行</td>
							<td width="25%" height="25"><input type="radio"
								name="pd_FrpId" value="ABC-NET">农业银行</td>
							<td width="24%" height="25"><input type="radio"
								name="pd_FrpId" value="CCB-NET">建设银行</td>
						</tr>
						<tr>
							<td height="25"><input type="radio" name="pd_FrpId"
								value="CMBC-NET">中国民生银行总行</td>
							<td height="25"><input type="radio" name="pd_FrpId"
								value="CEB-NET">光大银行</td>
							<td height="25"><input type="radio" name="pd_FrpId"
								value="BOCO-NET">交通银行</td>
							<td height="25"><input type="radio" name="pd_FrpId"
								value="SDB-NET">深圳发展银行</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4" align="center"><input type="submit"
								value=" 确认支付 " /></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>