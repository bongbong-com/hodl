package com.bongbong.hodl.shared.lightning.responses;

import com.google.gson.annotations.Expose;
import lombok.Data;

public @Data class ReceiveResponse {
    @Expose String payment_hash, payment_request;
}
