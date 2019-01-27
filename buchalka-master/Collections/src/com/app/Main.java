package com.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);
//        theatre.getSeats();

        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay, seat has been reserved");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay, seat has been reserved");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        if (theatre.reserveSeat("B13")) {
            System.out.println("Please pay, seat has been reserved");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        // Collections.reverse is using the Comparable compareTo method for sorting
        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        // Collections is using the Comparator object to sort
        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);

    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat: list) {
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice() + ", ");
        }
        System.out.println();
        System.out.println("==================");
    }

}
