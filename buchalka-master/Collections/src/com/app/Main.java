package com.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);
//        theatre.getSeats();

//        if (theatre.reserveSeat("H11")) {
//            System.out.println("Please pay, seat has been reserved");
//        } else {
//            System.out.println("Sorry, seat is taken");
//        }
//
//        if (theatre.reserveSeat("H11")) {
//            System.out.println("Please pay, seat has been reserved");
//        } else {
//            System.out.println("Sorry, seat is taken");
//        }

        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats); // makes a shallow copy. different lists, but refers to same seat objects.

        //Collections.reverse(seatCopy);
        Collections.shuffle(seatCopy);


        System.out.println("Printing seat copy");
        printList(seatCopy);

        System.out.println("Printing theatre.seats");
        printList(theatre.seats);

        System.out.println("min seat: " + Collections.min(seatCopy).getSeatNumber());
        System.out.println("max seat: " + Collections.max(seatCopy).getSeatNumber());

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);

        // Collections.copy does not work as expected...need particular conditions for it to work
        // List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
        // Collections.copy(newList, theatre.seats);
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat: list) {
            System.out.println(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("==================");
    }

    // custom sort with Collections.swap
    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
