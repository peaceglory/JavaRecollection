package oop.design.patterns.dzone.facade;

import java.util.ArrayList;
import java.util.Date;

public class HotelBooker {

    public ArrayList<Hotel> getHotelNamesFor(Date from, Date to) {
        //returns hotels available in the particular date range
        return new ArrayList<>();
    }

    static class Hotel {

    }
}
