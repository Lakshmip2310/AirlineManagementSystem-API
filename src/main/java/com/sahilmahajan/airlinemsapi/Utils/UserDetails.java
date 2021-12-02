package com.sahilmahajan.airlinemsapi.Utils;

public class UserDetails {

    private String AppCodeName;
    private String AppVersion;
    private String UserAgent;
    private String OperatingSystem;
    private String ip;
    private String Latitude;
    private String Longitude;



    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getAppCodeName() {
        return AppCodeName;
    }

    public void setAppCodeName(String appCodeName) {
        AppCodeName = appCodeName;
    }

    public String getAppVersion() {
        return AppVersion;
    }

    public void setAppVersion(String appVersion) {
        AppVersion = appVersion;
    }

    public String getUserAgent() {
        return UserAgent;
    }

    public void setUserAgent(String userAgent) {
        UserAgent = userAgent;
    }

    public String getOperatingSystem() {
        return OperatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        OperatingSystem = operatingSystem;
    }

    public String getIP() {
        return ip;
    }

    public void setIP(String IP) {
        this.ip = IP;
    }
}
