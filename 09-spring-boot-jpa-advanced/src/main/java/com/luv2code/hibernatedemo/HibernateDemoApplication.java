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
            // createInstructor(appDAO);
            // findInstructor(appDAO);
            // deleteInstructor(appDAO);
            findInstructorDetail(appDAO);
        };
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int theId = 2;
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        System.out.println("tempInstructorDetail: " + tempInstructorDetail);
        System.out.println("the associated instructor: "
                + tempInstructorDetail.getInstructor());
        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor is: " + theId);

        Instructor theInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + theInstructor);
        System.out.println("the associated instructorDetail only: "
                + theInstructor.getInstructorDetail());
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