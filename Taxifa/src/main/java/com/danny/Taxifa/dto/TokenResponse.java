package com.danny.taxifa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Builder
@Data
public class TokenResponse {


    private final String token;

    @JsonProperty(value = "expires_At")
    private final Date expiresAt;

    @JsonProperty(value = "issued_At")
    private final Date issuedAt;


    public TokenResponse(String token, Date expiresAt, Date issuedAt) {
        this.token = token;
        this.expiresAt = expiresAt;
        this.issuedAt = issuedAt;
    }

    public String getToken() {
        return token;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }



}
