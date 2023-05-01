package com.yearup;

import java.util.ArrayList;
import java.util.Scanner;

public class Capstone {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        homeScreen(scanner);


    }

    public static void homeScreen(Scanner scanner) {

        String choice = "";
        while (!choice.equalsIgnoreCase("x")) {
            if (!choice.equalsIgnoreCase("P")) {
                if (!choice.equalsIgnoreCase("L")) {
                    System.out.println("Ledger Accounting Application");
                    System.out.println("------------------");
                    System.out.println("D.Make Deposit");
                    System.out.println("P.Make Payment(Debit Card)");
                    System.out.println("L.Ledger");
                    System.out.print("X.Exit");


                    choice = scanner.nextLine();
                    scanner.next();

                    switch (choice) {
                        case "D":
                            System.out.println("Make A Deposit");
                            System.out.println("Please Enter Your Deposit Information:");
                            depositInfo(scanner);

                            break;

                        case "P":
                            System.out.println("Make A Payment");
                            System.out.println("Please Enter Your Debit Card Info:");

                            break;

                        case "L":

                            System.out.println("Ledger");
                            System.out.println("Please Enter Your Debit Card Info:");


                            break;

                        case "X":
                            System.out.println("Goodbye!");
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }


            }
        }

    }

        public static void depositInfo(Scanner scanner){
            System.out.println("Please Input Deposit Information");
             String info = scanner.nextLine();

    }

}




