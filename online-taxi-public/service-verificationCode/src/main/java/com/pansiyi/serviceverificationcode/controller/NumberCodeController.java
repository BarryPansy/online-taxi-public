package com.pansiyi.serviceverificationcode.controller;

import com.pansiyi.internalcommon.dto.ResponseResult;
import com.pansiyi.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    public ResponseResult NumberCode(@PathVariable int size){

        System.out.println("size:"+size);
        double mathRandom = (Math.random() * 9 + 1) * Math.pow(10, size - 1);
        int numberCode = (int)mathRandom;
        System.out.println("generator src numberCode:"+numberCode);
        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(numberCode);

        return ResponseResult.success(response);

    }
}
