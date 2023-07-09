package com.luv2code.util;

import org.springframework.stereotype.Component;

@Component
/*@Primary*/
public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}