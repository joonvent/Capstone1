package com.yearup;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Capstone {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Transaction> transactions = new ArrayList<>();
    static DateTimeFormatter dateFormatter;
    static DateTimeFormatter timeFormatter;



    public static void main(String[] args) throws IOException {
        homeScreen(scanner);
        scanner.close();


    }

    public static void homeScreen(Scanner scanner) throws IOException {
        displayTransaction();
        String choice = "";
        while (!choice.equalsIgnoreCase("x")) {

            System.out.println("Ledger Accounting Application");
            System.out.println("------------------");
            System.out.println("D.Make Deposit");
            System.out.println("P.Make Payment(Debit Card)");
            System.out.println("L.Ledger");
            System.out.println("X.Exit");


            choice = scanner.nextLine().trim();


            switch (choice.toUpperCase()) {
                case "D":

                    depositInfo();
                    System.out.println("Thank You Deposit Added!");
                    System.out.println("Press any key to continue or X to exit.");
                    choice = scanner.nextLine().trim();

                    break;

                case "P":

                    payment(scanner);
                    System.out.println("Thank you Payment Added!");
                    System.out.println("Press any key to continue or X to exit.");
                    choice = scanner.nextLine().trim();

                    break;

                case "L":

                    ledger(scanner);


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

    public static void displayTransaction() {

        String storeTransactions = "transaction.csv";

        try {
            BufferedReader br = new BufferedReader(new FileReader(storeTransactions));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                LocalDate date = LocalDate.parse(parts[0], dateFormatter);
                LocalTime time = LocalTime.parse(parts[1], timeFormatter);

                String description = parts[2];
                String vendor = parts[3];
                Double amount = Double.parseDouble(parts[4]);

                Transaction newTransaction = new Transaction(date, time, description, vendor, amount);
                transactions.add(newTransaction);
                System.out.println(newTransaction);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Testing");
        }
    }

    public static void depositInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Make A Deposit");
        System.out.println("--------------");
        System.out.println("Please Input Deposit Information");
        System.out.print("Please Enter Date of Deposit(YYYY-mm-dd):");
        String date = scanner.nextLine();
        System.out.print("Please Enter Time(hh:mm:ss):");
        String time = scanner.nextLine();
        System.out.print("Please Enter A Description of the Deposit:");
        String description = scanner.nextLine();
        System.out.print("Please Enter The Vendor of the Payment:");
        String vendor = scanner.nextLine();
        System.out.print("Please Enter The Total Amount:");
        Double amount = scanner.nextDouble();


        try {

            FileWriter file = new FileWriter("transaction.csv", true);
            file.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount + "\n");
            file.close();


        } catch (Exception e) {

            e.printStackTrace();


        }



    }

    public static void payment(Scanner scanner) {
        System.out.println("Make A Payment");
        System.out.println("--------------");
        System.out.println("Please Input Payment Info");

        System.out.print("Please Enter Date of Payment(YYYY-mm-dd):");
        String date = scanner.nextLine();
        System.out.print("Please Enter Time(hh:mm:ss):");
        String time = scanner.nextLine();
        System.out.print("Please Enter A Description of the Payment:");
        String description = scanner.nextLine();
        System.out.print("Please Enter Vendor of the Payment:");
        String vendor = scanner.nextLine();
        System.out.print("Please Enter The Total Amount:");
        Double amount = scanner.nextDouble();

        try {


            FileWriter file = new FileWriter("transaction.csv", true);
            file.write(date + "|" + time + "|" + description + "|" + vendor + "|" + "-"+amount + "\n");
            file.close();


        } catch (Exception e) {

            e.printStackTrace();
        }


    }


    public static void ledger(Scanner scanner) throws IOException {
        System.out.println("_____Welcome to Ledger_____");
        String choice = "";
        while (!choice.equalsIgnoreCase("x")) {
            System.out.println("Select One:");
            System.out.println("------------------");
            System.out.println("A.Display All Entries");
            System.out.println("D.Display All Deposits");
            System.out.println("P.Display All Payments");
            System.out.println("R.Reports");
            System.out.println("H.Return Home");
            choice = scanner.nextLine().trim();


            switch (choice.toUpperCase()) {
                case "A":

                    displayALl();
                    System.out.println("Press any key to go back or X to exit.");
                    choice = scanner.nextLine().trim();
                    break;

                case "D":
                    displayDeposits();
                    System.out.println("Press any key to go back or X to exit.");
                    choice = scanner.nextLine().trim();
                    break;

                case "P":
                    displayPayments();
                    System.out.println("Press any key to go back or X to exit.");
                    choice = scanner.nextLine().trim();
                    break;

                case "R":
                    reportsMenu(scanner);
                    System.out.println("Reports");
                    System.out.println("Press any key to go back or X to exit.");
                    choice = scanner.nextLine().trim();
                    break;


                case "H":
                    return;


                default:
                    System.out.println("Invalid choice. Please try again.");

                    break;
            }
        }


    }

    public static void displayALl() throws IOException {
        // This method should display a table of all transactions in the `transactions` ArrayList.
        // The table should have columns for date, time, vendor, type, and amount.
        // The total balance of all transactions should be displayed at the bottom of the table.
        System.out.println("Here Are All Transactions:");
        for(Transaction all : transactions){
            if (all.getAmount() > 0){

            }
        //for (int i = 0; i < transactions.size(); i++) {
            System.out.println(all.getDate() + " | " + all.getTime() + " | " + all.getDescription() + " | " + all.getVendor() + " | " + all.getAmount()+ " |");
        }
    }

    public static void displayDeposits() {
        // This method should display a table of all deposits in the `transactions` ArrayList.
        // The table should have columns for date, time, vendor, and amount.
        // The total amount of all deposits should be displayed at the bottom of the table.
        System.out.println("Here Are All Deposits:");
        System.out.println("----------------------");
        for (Transaction deposit : transactions) {
            if (deposit.getAmount() > 0) {
                System.out.println(deposit.getDate() + " | " + deposit.getTime() + " | " + deposit.getDescription() + " | " + deposit.getVendor() + " | " + deposit.getAmount() + " |");
            }

        }


    }

    public static void displayPayments() {
        // This method should display a table of all payments in the `transactions` ArrayList.
        // The table should have columns for date, time, vendor, and amount.
        // The total amount of all payments should be displayed at the bottom of the table.
        System.out.println("Here Are All Payments:");
        System.out.println("---------------------:");
        for (Transaction payment : transactions) {
            if (payment.getAmount() < 0) {
                System.out.println(payment.getDate() + " | " + payment.getTime() + " | " + payment.getDescription() + " | " + payment.getVendor() + " | " + payment.getAmount() +" |");
            }


        }
    }


    private static void reportsMenu(Scanner scanner) throws IOException {
        boolean running = true;
        while (running) {
            System.out.println("Reports");
            System.out.printf("Choose an option:%n%n");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");
            String input = scanner.nextLine().trim();


                switch (input) {
                    case "1":
                    for (Transaction transactions : transactions) { //looping through transactions
                        LocalDate date = LocalDate.now();//get todays date

                        if (transactions.getDate().getMonth() == date.getMonth()) {//going to get date and month from array, to compare if theyre equal
                            System.out.println(transactions.getDate() + " | " + transactions.getVendor() + " | " + transactions.getDescription());//If theyre equal this will print

                        }
                    }
                        System.out.println("----------------------------------------");
                        System.out.println("Here Are Your Month to Date Transactions");
                    break;
                    case "2":
                        for (Transaction transactions : transactions) {//looping through
                            LocalDate date = LocalDate.now();//get todays date
                            LocalDate previousMonth = date.minusMonths(1);//new variable called previous month,Going to remove 1 from the month so that it only displays the LAST months transactions

                            if (transactions.getDate().getMonth() == previousMonth.getMonth()) { //If the month is equal to previous month
                                System.out.println(transactions.getDate() + " | " + transactions.getVendor() + " | " + transactions.getDescription());//perform this action

                            }
                        }
                        System.out.println("----------------------------------------");
                        System.out.println("Here Are Your Previous Month Transactions");

                    break;

                    case "3":
                    for (Transaction transactions : transactions) { //looping through transactions
                        LocalDate date = LocalDate.now();//get todays date

                        if (transactions.getDate().getYear() == date.getYear()) {//going to get the year, to compare if theyre equal
                            System.out.println(transactions.getDate() + " | " + transactions.getVendor() + " | " + transactions.getDescription());//If theyre equal this will print all transactions within with year

                        }
                    }
                        System.out.println("----------------------------------------");
                        System.out.println("Here Are Your Year to Date Transactions");
                    break;

                    case "4":
                    for (Transaction transactions : transactions) {
                        LocalDate date = LocalDate.now();//get todays date
                        LocalDate yearToDate = date.minusYears(1);

                        if (transactions.getDate().getYear() == yearToDate.getYear()) {//going to get date and month from array
                            System.out.println(transactions.getDate() + " | " + transactions.getVendor() + " | " + transactions.getDescription() + " | ");

                        }

                    }
                        System.out.println("----------------------------------------");
                        System.out.println("Here Are Your Previous Year Transactions");
                    break;

                     case "5":
                            System.out.println("Search By Vendor");
                             System.out.println("Please Enter The Vendor You Are Searching For:");
                             String searchVendor = scanner.nextLine();

                         for (Transaction transactions : transactions) {

                             if (transactions.getVendor().equalsIgnoreCase(searchVendor)){
                                 System.out.println("Transactions Matched With Vendor\n" + transactions.getDate()+ " | " + transactions.getVendor() + " | " +transactions.getDescription() + " | " + transactions.getAmount()+" | " );
                             }
                         }

                         break;
                case "0":
                        ledger(scanner);
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}


