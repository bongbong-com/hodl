package com.bongbong.hodl.shared.lightning.responses;

import com.google.gson.annotations.Expose;
import lombok.Data;


public @Data class WalletInfoResponse {
    @Expose String id, name;
    @Expose int balance;
}
