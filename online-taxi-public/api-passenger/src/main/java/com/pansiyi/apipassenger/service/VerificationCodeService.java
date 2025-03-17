package com.pansiyi.apipassenger.service;

import com.pansiyi.apipassenger.remote.ServiceVerificationcodeClient;
import com.pansiyi.internalcommon.dto.ResponseResult;
import com.pansiyi.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationCodeService {

    @Autowired
    private ServiceVerificationcodeClient  serviceVerificationcodeClient;

    public String generateCode(String passengerPhone) {

        //获得验证码
        System.out.println("调用验证码服务，获取验证码");

        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numbercode = numberCodeResponse.getData().getNumberCode();

        System.out.println("remote number code" + numbercode) ;

        //存入redis
        System.out.println("存入redis");

        //返回json
        JSONObject result = new JSONObject();
        result.put("code", 1);
        result.put("message", "success");
        return result.toString();
    }
}
