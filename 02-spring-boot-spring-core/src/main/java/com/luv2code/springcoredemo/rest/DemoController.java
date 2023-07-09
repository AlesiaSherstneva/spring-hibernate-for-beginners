package com.luv2code.springcoredemo.rest;

import com.luv2code.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    // constructor dependency injection

    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach theCoach) {
        this.myCoach = theCoach;
    }

    // setter dependency injection

/*    @Autowired
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }*/

    // we can give any name for the setter

/*    @Autowired
    public void doSomeStuff(Coach theCoach) {
        myCoach = theCoach;
    }*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}