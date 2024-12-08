package com.bongbong.hodl.shared.data.impl;

import com.bongbong.hodl.shared.data.DataStore;
import com.bongbong.hodl.shared.profile.Profile;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.UUID;

public class MongoDataStore implements DataStore {
    private final MongoClient client;
    private final MongoDatabase database;

    public MongoDataStore(String mongoURI, String database) {
        this.client = MongoClients.create(mongoURI);
        this.database = client.getDatabase(database);
    }

    @Override
    public void saveProfile(Profile profile) {

    }

    @Override
    public Profile loadProfile(UUID playerId) {
        return null;
    }

    @Override
    public void close() {
        client.close();
    }
}
