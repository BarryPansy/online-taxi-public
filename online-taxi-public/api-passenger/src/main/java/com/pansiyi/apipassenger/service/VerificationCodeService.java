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

    /**
     * 生成验证码
     * @param passengerPhone 手机号
     * @return
     */
    public ResponseResult generateCode(String passengerPhone) {


        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numbercode = numberCodeResponse.getData().getNumberCode();

        String key = verificationCodePrefix + passengerPhone;
        stringRedisTemplate.opsForValue().set(key, numbercode+"", 2, TimeUnit.MINUTES);


        return ResponseResult.success();
    }

    /**
     * 校验验证码
     * @param passengerPhont 手机号
     * @param verificationCode 验证码
     * @return
     */
    public ResponseResult checkCode(String passengerPhont, String verificationCode) {
        //根据手机号去redis读取验证码

        //校验验证码

        //判断原来是否有用户，并进行对应处理

        //颁布令牌

        return null;
    }
}
