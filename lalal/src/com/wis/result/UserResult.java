package com.wis.result;

public class UserResult {
	private int status;
	private Object data;
	

	public String toString() {
		return "UserResult [status=" + status + ", data=" + data + "]";
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
