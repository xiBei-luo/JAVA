package com.yc.util;


import java.io.StringWriter;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * ¹¤¾ßJSON´úÂë
 * @author Administrator
 *
 */
public class JsonConvert {
	static String  jsonStr;
	public static String returnJson(Object object) throws Exception{
		ObjectMapper objectMapper=new ObjectMapper();
		StringWriter stringWriter=new StringWriter();
		objectMapper.writeValue(stringWriter, object);
		jsonStr = stringWriter.toString();
		return jsonStr;
	}
}
