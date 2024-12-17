package com.bongbong.hodl.shared.profile;

import org.jetbrains.annotations.NotNull;

public record WalletInfo(@NotNull String userId, @NotNull String walletId, @NotNull String adminKey, @NotNull String invoiceKey) {
}
