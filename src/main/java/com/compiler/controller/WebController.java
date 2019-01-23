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
    public Map<String, String> compile(
            @RequestParam("lang") String lang,
            @RequestParam("code") String code
    ) {
        WebCompiler compiler = new WebCompiler();
        String result = "";
        try {
            result = compiler.execte(code);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        Map<String, String> data = new HashMap<>();
        data.put("result", result);

        return data;
    }
}