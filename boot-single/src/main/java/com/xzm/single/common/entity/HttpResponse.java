package com.xzm.single.common.entity;


import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
public class HttpResponse extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public HttpResponse() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static HttpResponse error() {
		return error(0, "请求错误");
	}
	
	public static HttpResponse error(String msg) {
		return error(0, msg);
	}
	
	public static HttpResponse error(int code, String msg) {
		HttpResponse r = new HttpResponse();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static HttpResponse ok(String msg) {
		HttpResponse r = new HttpResponse();
		r.put("msg", msg);
		return r;
	}
	
	public static HttpResponse ok(Map<String, Object> map) {
		HttpResponse r = new HttpResponse();
		r.putAll(map);
		return r;
	}
	
	public static HttpResponse ok() {
		return new HttpResponse();
	}

	public HttpResponse put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
