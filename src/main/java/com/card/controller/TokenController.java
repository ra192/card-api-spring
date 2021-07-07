package com.card.controller;

import com.card.controller.dto.CreateTokenDto;
import com.card.controller.dto.TokenDto;
import com.card.service.TokenService;
import com.card.service.MerchantService;
import com.card.service.exception.TokenException;
import com.card.service.exception.MerchantException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/token")
public class TokenController extends BaseController {
    private final MerchantService merchantService;
    private final TokenService tokenService;

    public TokenController(MerchantService merchantService, TokenService tokenService) {
        this.merchantService = merchantService;
        this.tokenService = tokenService;
    }

    @PostMapping
    public TokenDto create(@RequestBody CreateTokenDto requestObj) throws MerchantException,
            NoSuchAlgorithmException, TokenException {
        final var token = tokenService.createToken(merchantService.getById(requestObj.getMerchantId()), requestObj.getSecret());

        return new TokenDto(token.getToken(), token.getExpiredAt());
    }
}