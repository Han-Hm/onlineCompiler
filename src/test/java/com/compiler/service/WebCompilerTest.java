package com.compiler.service;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({WebCompiler.class, FileUtils.class})
public class WebCompilerTest {
	@Spy
	private WebCompiler webCompiler = new WebCompiler();
	
	@Test
	public void testCompile() {
		//TODO after refactoring...
	}
	
//	@Test
//	public void testExecte() throws Exception{
//		//Given
//		String testCode = "System.out.print(\"Hello\");";
//
//		UUID mockedUUID = PowerMockito.mock(UUID.class);
//		PowerMockito.mockStatic(UUID.class);
//		PowerMockito.when(UUID.randomUUID()).thenReturn(mockedUUID);
//
//		String testAbsolutePath = "C:\\dev\\test\\test_dir";
//		File mockedJavaFile = mock(File.class);
//		File mockedClassFile = mock(File.class);
//		File[] mockedListFiles = {mockedJavaFile, mockedClassFile};
//		File mockedCompileFolder = mock(File.class);
//		doReturn(testAbsolutePath).when(mockedCompileFolder).getAbsolutePath();
//		doReturn(mockedListFiles).when(mockedCompileFolder).listFiles();
//
//		PowerMockito.whenNew(File.class).withArguments(WebCompiler.COMPILE_DIR + mockedUUID).thenReturn(mockedCompileFolder);
//
//		File mockedFile = mock(File.class);
//		PowerMockito.whenNew(File.class).withArguments(testAbsolutePath + "\\Test.java").thenReturn(mockedFile);
//
//		PowerMockito.mockStatic(FileUtils.class);
//
//		doReturn("Hello").when(webCompiler).compile(mockedFile);
//
//		//When
//		String actual = webCompiler.execte(testCode);
//
//		//Then
//		assertEquals(actual, "Hello");
//		verify(mockedCompileFolder, times(1)).mkdirs();
//		PowerMockito.verifyStatic(FileUtils.class, times(1));
//		FileUtils.writeStringToFile(mockedFile, testCode, Charset.forName("utf-8"));
//		verify(mockedJavaFile, times(1)).delete();
//		verify(mockedClassFile, times(1)).delete();
//		verify(mockedCompileFolder, times(1)).delete();
//	}
//
//	@Test
//	public void testExecteWithException() throws Exception{
//		//Given
//		String testCode = "System.out.print(\"Hello\");";
//
//		UUID mockedUUID = PowerMockito.mock(UUID.class);
//		PowerMockito.mockStatic(UUID.class);
//		PowerMockito.when(UUID.randomUUID()).thenReturn(mockedUUID);
//
//		String testAbsolutePath = "C:\\dev\\test\\test_dir";
//		File mockedJavaFile = mock(File.class);
//		File mockedClassFile = mock(File.class);
//		File[] mockedListFiles = {mockedJavaFile, mockedClassFile};
//		File mockedCompileFolder = mock(File.class);
//		doReturn(testAbsolutePath).when(mockedCompileFolder).getAbsolutePath();
//		doReturn(mockedListFiles).when(mockedCompileFolder).listFiles();
//
//		PowerMockito.whenNew(File.class).withArguments(WebCompiler.COMPILE_DIR + mockedUUID).thenReturn(mockedCompileFolder);
//
//		File mockedFile = mock(File.class);
//		PowerMockito.whenNew(File.class).withArguments(testAbsolutePath + "\\Test.java").thenReturn(mockedFile);
//
//		PowerMockito.mockStatic(FileUtils.class);
//		doThrow(new IOException()).when(webCompiler).compile(mockedFile);
//
//		//When
//		try {
//			webCompiler.execte(testCode);
//		} catch (IOException e) {
//		//Then
//			verify(mockedCompileFolder, times(1)).mkdirs();
//			PowerMockito.verifyStatic(FileUtils.class, times(1));
//			FileUtils.writeStringToFile(mockedFile, testCode, Charset.forName("utf-8"));
//			verify(mockedJavaFile, times(1)).delete();
//			verify(mockedClassFile, times(1)).delete();
//			verify(mockedCompileFolder, times(1)).delete();
//		} catch (Exception e) {
//			fail();
//		}
//	}

}
