package com.compiler.controller;

import static com.compiler.util.UnitTestUtils.jsonStringContent;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.compiler.service.WebCompiler;

@RunWith(PowerMockRunner.class)
@PrepareForTest({WebController.class})
public class WebControllerTest {
	
	private WebController webController = new WebController();
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(webController).build();
	}
	
//	@Test
//	public void testIndex() throws Exception{
//		//Given
//		String testApiPath = "/";
//
//		//When
//		mockMvc.perform(get(testApiPath))
//
//		//Then
//		.andExpect(status().isOk())
//		.andExpect(view().name("index"))
//		.andDo(print());
//	}
//
//	@Test
//	public void testHello() throws Exception{
//		//Given
//		String testApiPath = "/hello";
//
//		//When
//		try { //FIXME remove try, catch
//			mockMvc.perform(get(testApiPath))
//
//		//Then
//			.andExpect(status().isOk())
//			.andExpect(view().name("hello"))
//			.andDo(print());
//		} catch(ServletException e) {
//			//TODO add ViewResolver
//		} catch(Exception e) {
//			fail();
//		}
//	}
//
//	@Test
//	public void testCompile() throws Exception{
//		//Given
//		String testApiPath = "/compile";
//		String testLang = "java";
//		String testCode = "System.out.print(\"Hello\");";
//
//		WebCompiler mockedWebCompiler = mock(WebCompiler.class);
//		PowerMockito.whenNew(WebCompiler.class).withNoArguments().thenReturn(mockedWebCompiler);
//		doReturn("Hello").when(mockedWebCompiler).execte(eq(testCode));
//
//		//When
//		mockMvc.perform(post(testApiPath)
//				.param("lang", testLang)
//				.param("code", testCode))
//
//		//Then
//		.andExpect(status().isOk())
//		.andExpect(jsonStringContent("{\"result\":\"Hello\"}"))
//		.andDo(print());
//	}
//
//	@Test
//	public void testCompileWithException() throws Exception{
//		//Given
//		String testApiPath = "/compile";
//		String testLang = "java";
//		String testCode = "System.out.print(\"Hello\");";
//
//		WebCompiler mockedWebCompiler = mock(WebCompiler.class);
//		PowerMockito.whenNew(WebCompiler.class).withNoArguments().thenReturn(mockedWebCompiler);
//		doThrow(new IOException()).when(mockedWebCompiler).execte(eq(testCode));
//
//		//When
//		mockMvc.perform(post(testApiPath)
//				.param("lang", testLang)
//				.param("code", testCode))
//
//		//Then
//		.andExpect(status().isOk())
//		.andExpect(jsonStringContent("{\"result\":\"\"}"))
//		.andDo(print());
//	}
}

