package com.bongbong.hodl.shared.lightning;

import com.bongbong.hodl.shared.lightning.responses.PayResponse;
import com.bongbong.hodl.shared.lightning.responses.ReceiveResponse;
import com.bongbong.hodl.shared.lightning.responses.UserManagerCreateResponse;
import com.bongbong.hodl.shared.lightning.responses.WalletInfoResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;

import java.io.IOException;
import java.util.UUID;

public class Requests {
    private static final String HOST_BASE_URL_LNBIT = System.getenv("HOST_BASE_URL_LNBIT");
    private static final String HOST_ADMIN_KEY_LNBIT = System.getenv("HOST_ADMIN_KEY_LNBIT");
    private static final String HOST_INVOICE_KEY_LNBIT = System.getenv("HOST_INVOICE_KEY_LNBIT");

    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static UserManagerCreateResponse createWallet(UUID uuid, String username, OkHttpClient client, Gson gson) {
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(HOST_BASE_URL_LNBIT + "/usermanager/api/v1/users")
                .newBuilder();

        String json = "{\"admin_id\": \"" + HOST_ADMIN_KEY_LNBIT + "\", \"wallet_name\": \""
                + uuid.toString() + "\", \"user_name\": \"" + username + "\"}";

        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .post(body)
                .addHeader("X-Api-Key", HOST_INVOICE_KEY_LNBIT)
                .addHeader("Content-type", "application/json; charset=utf-8")
                .build();

        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            return gson.fromJson(response.body().string(), UserManagerCreateResponse.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public static WalletInfoResponse getWalletBalance(String walletReadKey, OkHttpClient client, Gson gson) {
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(HOST_BASE_URL_LNBIT + "/api/v1/wallet")
                .newBuilder();

        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .addHeader("Content-type", "application/json")
                .addHeader("X-Api-Key", walletReadKey)
                .build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            return gson.fromJson(response.body().string(), WalletInfoResponse.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public static PayResponse payInvoice(String bolt11, String adminKey, OkHttpClient client, Gson gson) {
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(HOST_BASE_URL_LNBIT + "/api/v1/payments")
                .newBuilder();

        String json = "{\"out\": true, \"bolt11\": " + bolt11 + "}";
        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .post(body)
                .addHeader("Content-type", "application/json")
                .addHeader("X-Api-Key", adminKey)
                .build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            return gson.fromJson(response.body().string(), PayResponse.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public static ReceiveResponse createInvoice(int amount, String memo, String adminKey, OkHttpClient client, Gson gson) {
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(HOST_BASE_URL_LNBIT + "/api/v1/payments")
                .newBuilder();

        String json = "{\"out\": false, \"amount\": " + amount + ", \"memo\": " + memo +"}";
        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .post(body)
                .addHeader("Content-type", "application/json")
                .addHeader("X-Api-Key", adminKey)
                .build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            return gson.fromJson(response.body().string(), ReceiveResponse.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return null;
    }

}
