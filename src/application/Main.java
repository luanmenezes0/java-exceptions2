package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data: ");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        Double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        Double limit = sc.nextDouble();

        Account account = new Account(number, holder, balance, limit);
        System.out.println();

        System.out.print("Enter amount for withdraw: ");
        double amount = sc.nextDouble();
        try {
            account.withdraw(amount);
            System.out.println();
            System.out.println(account.getBalance());
        } catch (DomainException e) {
            System.out.println(e.getMessage());
        }


        sc.close();
    }
}
