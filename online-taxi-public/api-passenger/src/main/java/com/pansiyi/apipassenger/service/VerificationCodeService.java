package com.pansiyi.apipassenger.service;

import com.pansiyi.apipassenger.remote.ServiceVerificationcodeClient;
import com.pansiyi.internalcommon.dto.ResponseResult;
import com.pansiyi.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeService {

    @Autowired
    private ServiceVerificationcodeClient  serviceVerificationcodeClient;

    private String verificationCodePrefix = "passenger-verification-code-";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public ResponseResult generateCode(String passengerPhone) {


        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numbercode = numberCodeResponse.getData().getNumberCode();

        String key = verificationCodePrefix + passengerPhone;
        stringRedisTemplate.opsForValue().set(key, numbercode+"", 2, TimeUnit.MINUTES);


        return ResponseResult.success();
    }
}
