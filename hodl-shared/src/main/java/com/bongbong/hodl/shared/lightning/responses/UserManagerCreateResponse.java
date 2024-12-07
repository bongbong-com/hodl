package com.bongbong.hodl.shared.lightning.responses;

import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;
import lombok.Data;

public @Data class UserManagerCreateResponse {
    @Expose String id, name, admin, email, password;
    @Expose JsonArray wallets;

}
