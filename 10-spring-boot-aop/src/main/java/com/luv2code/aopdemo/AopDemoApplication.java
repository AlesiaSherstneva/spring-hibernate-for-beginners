package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        return runner -> {
            // demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
            // demoTheAfterReturningAdvice(theAccountDAO);
            // demoTheAfterThrowingAdvice(theAccountDAO);
            demoTheAfterAdvice(theAccountDAO);
        };
    }

    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
        demoTheAfterThrowingAdvice(theAccountDAO);
        demoTheAfterReturningAdvice(theAccountDAO);
    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;
        try {
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception exception) {
            System.out.println("\n\nMain Program: caught exception: " + exception);
        }

        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("-----------");

        System.out.println(theAccounts + "\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = theAccountDAO.findAccounts();

        System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
        System.out.println("-----------");

        System.out.println(theAccounts + "\n");
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        Account theAccount = new Account();
        theAccount.setName("Madhu");
        theAccount.setLevel("Platinum");

        theAccountDAO.addAccount(theAccount, true);
        theAccountDAO.doWork();

        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String serviceCode = theAccountDAO.getServiceCode();

        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();
    }
}