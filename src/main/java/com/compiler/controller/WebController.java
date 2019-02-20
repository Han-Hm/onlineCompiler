package com.compiler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.compiler.service.WebCompiler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WebController {
    private static final String Q1_ANSWER_PARAM = "5";
    private static final String Q1_ANSWER_EXPACTED = "15";

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "/compile", method = RequestMethod.POST)
    public Map<String, Object> compile(
            @RequestParam("lang") String lang,
            @RequestParam("code") String code,
            @RequestParam(value = "testParam", required = false) String testParam,
            @RequestParam(value = "expected", required = false) String expected
    ) {

        WebCompiler compiler = new WebCompiler();
        String result = "";
        boolean isAnswer = false;
        boolean isTestSuccess = true;
        try {

            Map<String, Object> answerData = compiler.execte(code, Q1_ANSWER_PARAM, Q1_ANSWER_EXPACTED);
            result = (String) answerData.get("result");
            isAnswer = (boolean) answerData.get("success");
            if (testParam != null && expected != null) {
                isTestSuccess = (boolean) compiler.execte(code, testParam, expected).get("success");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        Map<String, Object> data = new HashMap<>();
        data.put("result", result); // 출력값
        data.put("success", isAnswer); // 정답 여부
        data.put("testSuccess", isTestSuccess); // 테스트 케이스 성공 여부

        return data;
    }
}