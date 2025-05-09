package com.pansiyi.apipassenger.controller;

import com.pansiyi.apipassenger.request.VerificationCodeDTO;
import com.pansiyi.apipassenger.service.VerificationCodeService;
import com.pansiyi.internalcommon.dto.ResponseResult;
import com.pansiyi.internalcommon.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO) {

        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        System.out.println("successful accept " + passengerPhone);
        return verificationCodeService.generateCode(passengerPhone);

    }

    @PostMapping(("/verification-code-check"))
    public ResponseResult verificationCodeCheck(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        String verificationCode = verificationCodeDTO.getVerificationCode();
        System.out.println("手机号" + passengerPhone + ",验证码" + verificationCode);
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken("token value");

        return ResponseResult.success(tokenResponse);
    }
}
