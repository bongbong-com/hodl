package com.bongbong.hodl.shared.economy;

import com.bongbong.hodl.shared.lightning.Requests;
import com.bongbong.hodl.shared.lightning.responses.PayResponse;
import com.bongbong.hodl.shared.lightning.responses.ReceiveResponse;
import com.bongbong.hodl.shared.lightning.responses.WalletInfoResponse;
import com.bongbong.hodl.shared.profile.Profile;
import com.bongbong.hodl.shared.profile.ProfileManager;
import com.bongbong.hodl.shared.profile.WalletInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;

import java.util.UUID;

@RequiredArgsConstructor
public class EconomyImplementation implements EconomyInterface {
    private final ProfileManager profileManager;
    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    private final OkHttpClient client = new OkHttpClient().newBuilder().followSslRedirects(true).build();

    @Override
    public boolean transfer(UUID sender, UUID receiver, int amount_msat) {
        Profile senderProfile = profileManager.getProfile(sender);
        Profile receiverProfile = profileManager.getProfile(receiver);

        if (senderProfile == null || receiverProfile == null) return false;

        WalletInfo senderWallet = senderProfile.walletInfo();
        WalletInfo receiverWallet = receiverProfile.walletInfo();

        WalletInfoResponse senderWalletInfo = Requests.getWalletBalance(senderWallet.invoiceKey(), client, gson);
        if (senderWalletInfo == null) return false;

        if (senderWalletInfo.getBalance() < amount_msat) return false;

        ReceiveResponse receiveResponse = Requests.createInvoice(amount_msat, "Transfer", receiverWallet.adminKey(), client, gson);
        if (receiveResponse == null) return false;

        String invoice = receiveResponse.getPayment_hash();

        PayResponse payResponse = Requests.payInvoice(invoice, senderWallet.adminKey(), client, gson);
        return payResponse != null;
    }

    @Override
    public int getBalance(UUID player) {
        Profile profile = profileManager.getProfile(player);
        if (profile == null) return 0;

        WalletInfo walletInfo = profile.walletInfo();
        WalletInfoResponse response = Requests.getWalletBalance(walletInfo.invoiceKey(), client, gson);
        if (response == null) return 0;

       return response.getBalance();
    }
}
