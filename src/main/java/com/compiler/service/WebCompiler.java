package com.compiler.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by HHM on 2019-01-21.
 */
public class WebCompiler {
    static final String COMPILE_DIR = "C:\\dev\\test\\";
    static final String ANSWER_PREFIX = "#ANSER#";

    public String compile(File sourceFile) throws IOException, InterruptedException {
        String[] command = new String[] {"javac", sourceFile.getAbsolutePath() };

        ProcessBuilder builder = new ProcessBuilder(command);
        builder.redirectErrorStream(true);
        Process process = builder.start();

        process.waitFor();
        File classFile = null;
        for (File f : sourceFile.getParentFile().listFiles()) {
            if ("class".equals(FilenameUtils.getExtension(f.getName()))) {
                classFile = f;
                break;
            }
        }
        if (classFile == null) {
            return "ERROR";
        }

        process.destroy();
        command = new String[] {"java", "-cp", classFile.getParent(), FilenameUtils.getBaseName(classFile.getName()) };

        builder = new ProcessBuilder(command);
        builder.redirectErrorStream(true);
        process = builder.start();

        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "MS949"))) {
            process.waitFor();
            String line = bufferedReader.readLine();
            while (line != null) {
                result.append(line);
                result.append("\n");
                line = bufferedReader.readLine();
            }
        }

        process.destroy();

        return result.toString();
    }

    public Map<String, Object> execte(String code, String param, String expected) throws IOException, InterruptedException {

        File compileFolder = new File(COMPILE_DIR + UUID.randomUUID());
        Map<String, Object> retVal = new HashMap<>();
        String sResult = "ERROR";
        boolean bResult = false;
        try {
            compileFolder.mkdirs();

            File file = new File(compileFolder.getAbsolutePath() + "\\Solution.java");

            code = code.substring(0, code.lastIndexOf("}")) +
                    "\tpublic static void main(String[] args) {\n" +
                    "\t\tSolution sol = new Solution();\n" +
                    "\t\tint result = sol.solution(" + param + ");\n" +
                    "\t\tSystem.out.println(\"" + ANSWER_PREFIX + "\");\n" +
                    "\t\tSystem.out.println(result == " + expected + ");\n" +
                    "\t}\n" +
                    "}";
            FileUtils.writeStringToFile(file, code, Charset.forName("utf-8"));

            sResult = compile(file);
            String[] aResult = sResult.split(ANSWER_PREFIX);
            sResult = aResult[0];
            bResult = aResult[1].indexOf("true") > -1;
        } finally {
            for(File des : compileFolder.listFiles()){
                des.delete();
            }
            compileFolder.delete();
        }

        retVal.put("success", bResult);
        retVal.put("result", sResult);

        return retVal;
    }
}
