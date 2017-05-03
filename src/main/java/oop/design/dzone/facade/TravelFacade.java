package oop.design.dzone.facade;

import java.util.ArrayList;
import java.util.Date;

public class TravelFacade {
    private HotelBooker hotelBooker;
    private FlightBooker flightBooker;

    public void getFlightsAndHotels(Date from, Date to) {
        ArrayList<FlightBooker.Flight> flights = flightBooker.getFlightsFor(from, to);
        ArrayList<HotelBooker.Hotel> hotels = hotelBooker.getHotelNamesFor(from, to);
    }

}
