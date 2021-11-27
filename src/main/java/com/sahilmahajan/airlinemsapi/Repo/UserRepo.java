package com.sahilmahajan.airlinemsapi.Repo;

import com.mongodb.MongoClientException;
import com.mongodb.client.model.Filters;
import com.sahilmahajan.airlinemsapi.Utils.CreateUserUtil;
import com.sahilmahajan.airlinemsapi.Utils.MongoDB;
import org.bson.Document;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserRepo {

    MongoDB mongoDB = new MongoDB();

    public boolean EmailCheck(String EmailID) {

        try {

            MongoDB.Connect("UserDetails");
            Document EmailCheck = mongoDB.getcollection().find(Filters.eq("EmailID", EmailID)).first();

            if (EmailCheck == null) {
                return false;
            }

            return true;
        } catch (MongoClientException mongoClientException) {
            mongoClientException.printStackTrace();
            return false;
        }
    }

    public boolean SaltInsertion(String EmailID, String Salt) {

        LocalDateTime DT = LocalDateTime.now();
        String DateTime = DT.toString();

        try {

            MongoDB.Connect("Salt");
            Document SaltInsert = new Document("EmailID", EmailID)
                    .append("Salt", Salt)
                    .append("DateTime", DateTime);

            mongoDB.getcollection().insertOne(SaltInsert);

            return true;
        } catch (MongoClientException mongoClientException) {
            mongoClientException.printStackTrace();
            return false;
        }
    }

    public boolean InsertNewUserData(String Name, String EmailID, String PhoneNumber, String HashPassword) {

        LocalDateTime DT = LocalDateTime.now();
        String DateTime = DT.toString();

        try {
            MongoDB.Connect("UserDetails");
            Document InsertUserDetails = new Document("EmailID", EmailID)
                    .append("Name", Name)
                    .append("PhoneNumber", PhoneNumber)
                    .append("Hash", HashPassword)
                    .append("DateTime", DateTime);

            mongoDB.getcollection().insertOne(InsertUserDetails);

            return true;
        } catch (MongoClientException mongoClientException) {
            mongoClientException.printStackTrace();
            return false;
        }
    }

    public String GetSalt(String EmailID) {

        try {
            MongoDB.Connect("Salt");
            Document GetSalt = mongoDB.getcollection().find(Filters.eq("EmailID", EmailID)).first();

            if (GetSalt == null) {
                return null;
            }

            if (GetSalt.getString("Salt").isEmpty()) {
                return null;
            }

            return GetSalt.getString("Salt");
        } catch (MongoClientException mongoClientException) {
            mongoClientException.printStackTrace();
            return null;
        }
    }

    public boolean VerifyHash(String EmailID, String Hash) {

        try {
            MongoDB.Connect("UserDetails");
            Document GetSalt = mongoDB.getcollection().find(Filters.eq("EmailID", EmailID)).first();

            if (GetSalt == null) {
                return false;
            }

            if (!Objects.equals(GetSalt.getString("Hash"), Hash)) {
                return false;
            }

            return true;
        } catch (MongoClientException mongoClientException) {
            mongoClientException.printStackTrace();
            return false;
        }
    }
}
