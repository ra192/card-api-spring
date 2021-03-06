package com.card.controller.objs;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateTokenRequest {
    @NotNull
    private Long merchantId;
    @NotEmpty
    private String secret;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "CreateTokenDto{" +
                "merchantId=" + merchantId +
                ", secret='" + secret + '\'' +
                '}';
    }
}
