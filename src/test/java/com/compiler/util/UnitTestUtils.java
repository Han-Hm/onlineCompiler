package com.compiler.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UnitTestUtils {
	
	private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	public static boolean equalJsonString(String src1, String src2){
		
		Map<String,Object> map1 = new HashMap<String,Object>();
		Map<String,Object> map2 = new HashMap<String,Object>();
		try {
			map1 = OBJECT_MAPPER.readValue(src1, new TypeReference<Map<String, Object>>(){});
			map2 = OBJECT_MAPPER.readValue(src2, new TypeReference<Map<String, Object>>(){});
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return map1.equals(map2);
	}
	
	public static ResultMatcher jsonStringContent(final String expectedJsonString) {
		return new ResultMatcher() {
			public void match(MvcResult result) {
				try {
					String content = result.getResponse().getContentAsString();
					assertTrue("Expected : " + expectedJsonString + " But : " + content,
							UnitTestUtils.equalJsonString(content, expectedJsonString));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					fail();
				}
			}
		};
	}


}
