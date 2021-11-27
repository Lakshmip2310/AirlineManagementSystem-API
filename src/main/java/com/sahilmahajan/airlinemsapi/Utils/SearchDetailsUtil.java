package com.sahilmahajan.airlinemsapi.Utils;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SearchDetailsUtil {

    @NotNull
    @Max(15)
    private String Departure;

    @NotNull
    @Max(15)
    private String Arrival;

    @NotNull
    @Max(11)
    private String Date;

    @NotNull
    @Max(2)
    private String Count;

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }

    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String arrival) {
        Arrival = arrival;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }
}
