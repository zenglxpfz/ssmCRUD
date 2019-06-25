package com.zyq.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * ״̬��Ϣ������
 * 
 * 
 * */

public class Mag {
	
	
	   private int code;
	   private String msg;
	   private Map<String,Object> extend=new HashMap<String, Object>();//z����������洢�������Ǳߵ����ݣ�ͨ��key�õ�����
	 
	
  public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}


public static Mag success(){
	Mag result =new Mag();
	result.setCode(100);
	result.setMsg("����ɹ���");
	return result;
	
}

public static Mag fault(){
	Mag result =new Mag();
	result.setCode(200);
	result.setMsg("����ʧ�ܣ�");
	return result;
	
}

public Mag add(String key,Object value){
	
	this.getExtend().put(key, value);
	return this;
}


}

