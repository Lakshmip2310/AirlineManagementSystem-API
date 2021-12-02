package com.sahilmahajan.airlinemsapi.Operations;

import com.sahilmahajan.airlinemsapi.Utils.MongoDB;
import com.sahilmahajan.airlinemsapi.Utils.UserDetails;
import org.bson.Document;

public class StoreUserDetails {

    MongoDB mongoDB = new MongoDB();

    public boolean StoreDetails(UserDetails userDetails) {

        try {
            MongoDB.Connect("Details");

            Document Store = new Document("AppCodeName", userDetails.getAppCodeName())
                    .append("AppVersion", userDetails.getAppVersion())
                    .append("UserAgent", userDetails.getUserAgent())
                    .append("OS", userDetails.getOperatingSystem())
                    .append("IP", userDetails.getIP());

            mongoDB.getcollection().insertOne(Store);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
