package com.luv2code.hibernatedemo;

import com.luv2code.hibernatedemo.dao.AppDAO;
import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@SuppressWarnings("unused")
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
            // findInstructorDetail(appDAO);
            // deleteInstructorDetail(appDAO);
            // createInstructorWithCourses(appDAO);
            // findInstructorWithCourses(appDAO);
            // findCoursesForInstructor(appDAO);
            // findInstructorWithCoursesJoinFetch(appDAO);
            // updateInstructor(appDAO);
            updateCourse(appDAO);
        };
    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 10;
        System.out.println("Finding course id: " + theId);
        Course tempCourse = appDAO.findCourseById(theId);

        System.out.println("Updating course id: " + tempCourse.getId());
        tempCourse.setTitle("Enjoy the Simple Things");

        appDAO.update(tempCourse);
        System.out.println("Done!");
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("Updating instructor id: " + tempInstructor.getId());
        tempInstructor.setLastName("TESTER");

        appDAO.update(tempInstructor);
        System.out.println("Done!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);

        System.out.println("Finding courses for instructor id: " + theId);
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);
        tempInstructor.setCourses(courses);
        System.out.println("the associated courses: " + tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor(
                "Susan", "Public", "susan.public@luv2code.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.youtube.com", "Video Games");
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Course tempCourse1 = new Course("Air Guitar -  the Ultimate Guide");
        Course tempCourse2 = new Course("The Pinball Masterclass");
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);
        System.out.println("Done!");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 3;
        System.out.println("Deleting instructor detail id: " + theId);
        appDAO.deleteInstructorDetailById(theId);
        System.out.println("Done!");
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
        System.out.println("Finding instructor id: " + theId);

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