package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService){
		return runner -> {
			// demoTheAfterReturningAdvice(accountDAO);

			// demoTheAfterThrowingAdvice(accountDAO);

			// demoTheAfterAdvice(accountDAO);

			// demoTheAroundAdvice(trafficFortuneService);

			// demoTheAroundAdviceHandleException(trafficFortuneService);

			demoTheAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data + "\nFinished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data + "\nFinished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data + "\nFinished");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = null;

		try{
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = accountDAO.findAccounts(tripWire);
		} catch (Exception exc){
			System.out.println("\n\nMain Program: ... caught exception" + exc);
		}

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");

		System.out.println(theAccounts +  "\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = null;

		try{
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = accountDAO.findAccounts(tripWire);
		} catch (Exception exc){
			System.out.println("\n\nMain Program: ... caught exception" + exc);
		}

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");

		System.out.println(theAccounts +  "\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = accountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(theAccounts +  "\n");
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call the business method
		Account account = new Account();
		account.setName("John");
		account.setLevel("Platinum");

		accountDAO.addAccount(account, true);
		accountDAO.doWork();

		// call the accountdao setter/getter methods
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();

		// call the membership business method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
	}
}
