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
    // use @Qualifier for choosing a coach implementation

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = theCoach;
    }

    // we can use @Primary annotation to choose coach implementation by default

/*    @Autowired
    public DemoController(Coach theCoach) {
        // the track coach is annotated by @Primary
        this.myCoach = theCoach;
    }*/

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