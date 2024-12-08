package com.bongbong.hodl.shared.data.impl;

import com.bongbong.hodl.shared.data.DataStore;
import com.bongbong.hodl.shared.profile.Profile;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.Document;

import java.util.UUID;

public class MongoDataStore implements DataStore {
    private static final String COLLECTION_ID = "profiles";
    private final MongoClient client;
    private final MongoDatabase database;

    public MongoDataStore(String mongoURI, String database) {
        this.client = MongoClients.create(mongoURI);
        this.database = client.getDatabase(database);
    }

    @Override
    public void saveProfile(Profile profile) {
        final MongoCollection<Document> collection = database.getCollection(COLLECTION_ID);
        collection.replaceOne(Filters.eq("_id", profile.playerId()), profileToDocument(profile), new ReplaceOptions().upsert(true));
    }

    @Override
    public Profile loadProfile(UUID playerId) {
        final MongoCollection<Document> collection = database.getCollection(COLLECTION_ID);

        try (MongoCursor<Document> cursor = collection.find(Filters.eq("_id", playerId)).iterator()) {
            if (!cursor.hasNext()) {
                return null;
            }

            return documentToProfile(playerId, cursor.next());
        }
    }

    @Override
    public void close() {
        client.close();
    }

    private Document profileToDocument(Profile profile) {
        return new Document(); // TODO: update
    }

    private Profile documentToProfile(UUID playerId, Document document) {
        return new Profile(playerId);
    }
}
