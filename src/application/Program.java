package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.AccountException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.println("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.println("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.println("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			System.out.println();

			Account ac = new Account(number, holder, balance, withdrawLimit);

			System.out.println("Enter amount for withdraw: ");
			Double withdraw = sc.nextDouble();
			ac.withdraw(withdraw);
			System.out.println("New balance: " + ac.getBalance());
			
		} catch (AccountException e) {
			System.out.println("Withdraw error: "+ e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error");
			e.printStackTrace();
		}finally {
			sc.close();
			System.out.println("Closed");
		}		

	}

}
