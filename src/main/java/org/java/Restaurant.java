package org.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

 class Restaurant {
    private final String name;
    private final String address;
    private final String email;
    private final int capacity;
    private final LocalDateTime openingTime;
    private final LocalDateTime closingTime;
    private final List<LocalDate> closures;

    public Restaurant(String name, String address, String email, int capacity, LocalDateTime openingTime, LocalDateTime closingTime, List<LocalDate> closures) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.capacity = capacity;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.closures = closures;
    }
}