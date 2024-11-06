package org.java;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

public interface RestaurantManager {
    String addRestaurant(String name, String address, String email, int capacity, LocalDateTime openingTime, LocalDateTime closingTime, List<LocalDate> closures);

    String modifyRestaurant(String name, String address, String email, int capacity, LocalDateTime openingTime, LocalDateTime closingTime, List<LocalDate> closures);

    String removeRestaurant(String name);
}