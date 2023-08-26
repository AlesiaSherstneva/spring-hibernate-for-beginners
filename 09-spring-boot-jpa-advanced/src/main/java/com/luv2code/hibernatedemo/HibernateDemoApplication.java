package com.luv2code.hibernatedemo;

import com.luv2code.hibernatedemo.dao.AppDAO;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(HibernateDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            createInstructor(appDAO);
        };
    }

    private void createInstructor(AppDAO appDAO) {
/*        Instructor tempInstructor = new Instructor(
                "Chad", "Darby", "darby@luv2code.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.luv2code.com/youtube", "Luv 2 code!!!");
        tempInstructor.setInstructorDetail(tempInstructorDetail);*/

        Instructor tempInstructor = new Instructor(
                "Madhu", "Patel", "madhu@luv2code.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.luv2code.com/youtube", "Guitar");
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done!");
    }
}