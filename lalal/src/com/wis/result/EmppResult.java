package com.wis.result;

//将状态封装   {'status':stasus,'massage':massage,'date':date}
public class EmppResult {
	private int status;     //0表示成功状态
	private String message;  // 状态返回的信息  消息
	private Object data;     // 每个状态保存的数据   传出的数据
	

	@Override
	public String toString() {
		return "EmppResult [status=" + status + ", message=" + message
				+ ", data=" + data + "]";
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
	
	
	
	
	
}
