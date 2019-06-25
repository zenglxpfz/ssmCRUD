package com.zyq.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 状态信息返回类
 * 
 * 
 * */

public class Mag {
	
	
	   private int code;
	   private String msg;
	   private Map<String,Object> extend=new HashMap<String, Object>();//z这个属性来存储控制器那边的数据，通过key拿到数据
	 
	
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
	result.setMsg("处理成功！");
	return result;
	
}

public static Mag fault(){
	Mag result =new Mag();
	result.setCode(200);
	result.setMsg("处理失败！");
	return result;
	
}

public Mag add(String key,Object value){
	
	this.getExtend().put(key, value);
	return this;
}


}

