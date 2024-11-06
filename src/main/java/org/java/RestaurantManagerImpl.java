package org.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantManagerImpl implements RestaurantManager {
    private final Map<String, Restaurant> restaurants = new HashMap<>();

    @Override
    public String addRestaurant(String name, String address, String email, int capacity, LocalDateTime openingTime, LocalDateTime closingTime, List<LocalDate> closures) {
        validateParameters(name, address, email, capacity, openingTime, closingTime, closures);
        Restaurant restaurant = new Restaurant(name, address, email, capacity, openingTime, closingTime, closures);
        restaurants.put(name, restaurant);
        return "Restaurant added successfully.";
    }

    @Override
    public String modifyRestaurant(String name, String address, String email, int capacity, LocalDateTime openingTime, LocalDateTime closingTime, List<LocalDate> closures) {
        removeRestaurant(name);
        return addRestaurant(name, address, email, capacity, openingTime, closingTime, closures);
    }

    @Override
    public String removeRestaurant(String name) {
        if (restaurants.remove(name) != null) {
            return "Restaurant removed successfully.";
        } else {
            throw new RuntimeException("Restaurant not found.");
        }
    }

    private void validateParameters(String name, String address, String email, int capacity, LocalDateTime openingTime, LocalDateTime closingTime, List<LocalDate> closures) {
        if (name == null || address == null || email == null || openingTime == null || closingTime == null || closures == null) {
            throw new RuntimeException("Parameters must not be null.");
        }
        if (capacity <= 0) {
            throw new RuntimeException("Capacity must be a positive number.");
        }
        if (!openingTime.isBefore(closingTime)) {
            throw new RuntimeException("Opening time must be before closing time.");
        }
        if (closingTime.isBefore(openingTime.plusHours(8))) {
            throw new RuntimeException("Restaurant must be open for at least 8 hours.");
        }
        for (LocalDate closure : closures) {
            if (!closure.isAfter(LocalDate.now())) {
                throw new RuntimeException("Closure dates must be in the future.");
            }
        }
    }

}