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
static DateTimeFormatter formatter;

    public static void main(String[] args) throws IOException {

        homeScreen(scanner);
        scanner.close();

    }

    public static void homeScreen(Scanner scanner) throws IOException {
        String choice = "";
        while (!choice.equalsIgnoreCase("x")) {
            // if (!choice.equalsIgnoreCase("P")) {
            //  if (!choice.equalsIgnoreCase("D")) {
            System.out.println("Ledger Accounting Application");
            System.out.println("------------------");
            System.out.println("D.Make Deposit");
            System.out.println("P.Make Payment(Debit Card)");
            System.out.println("L.Ledger");
            System.out.println("X.Exit");


            choice = scanner.nextLine().trim();


            switch (choice.toUpperCase()) {
                case "D":
                    System.out.println("Press any key to continue or X to exit.");
                    choice = scanner.nextLine().trim();
                    depositInfo();


                    break;

                case "P":
                    System.out.println("Press any key to continue or X to exit.");
                    choice = scanner.nextLine().trim();
                    payment(scanner);


                    break;

                case "L":
                    System.out.println("Press any key to continue or X to exit.");
                    choice = scanner.nextLine().trim();
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


        //}
        // }

    }

    public static ArrayList<Transaction> displayTransaction() {

        String storeTransactions = "transaction.csv";
        try {
            BufferedReader br = new BufferedReader(new FileReader(storeTransactions));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");

                LocalDate date = LocalDate.parse(parts[0]);
                LocalTime time = LocalTime.parse(parts[1]);

                String description = parts[2];
                String vendor = parts[3];
                Double amount = Double.parseDouble(parts[4]);



                transactions.add(new Transaction(date, time, description, vendor, amount));
            }
            br.close();

        } catch (Exception e) {

        }
        return transactions;
    }

    public static void depositInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Make A Deposit");
        System.out.println("--------------");
        System.out.println("Please Input Deposit Information");
        System.out.print("Please Enter Date of Deposit:");
        String date = scanner.nextLine();
        System.out.print("Please Enter Time:");
        String time = scanner.nextLine();
        System.out.print("Please Enter A Description of the Deposit:");
        String description = scanner.nextLine();
        System.out.print("Please Enter The Total Amount:");
        Double amount = scanner.nextDouble();


        try {

            FileWriter file = new FileWriter("transaction.csv", true);
            file.write(date + "|" + time + "|" + description + "|" + amount + "\n");
            file.close();


        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    public static void payment(Scanner scanner) {
        System.out.println("Make A Payment");
        System.out.println("--------------");
        System.out.println("Please Input Payment Info");

        System.out.print("Please Enter Date of Payment:");
        String date = scanner.nextLine();
        System.out.print("Please Enter Time:");
        String time = scanner.nextLine();
        System.out.print("Please Enter A Description of the Payment:");
        String description = scanner.nextLine();
        System.out.print("Please Enter The Total Amount:");
        Double amount = scanner.nextDouble();

        try {


            FileWriter file = new FileWriter("transaction.csv", true);
            file.write(date + "|" + time + "|" + description + "|" + amount + "\n");
            file.close();


        } catch (Exception e) {

            e.printStackTrace();
        }


    }


    public static void ledger(Scanner scanner) throws IOException {
        System.out.println("Welcome to Ledger");
        System.out.println("-----------------");
        System.out.println("Please Select One bellow:");
        String choice = "";
        while (!choice.equalsIgnoreCase("x")) {


            System.out.println("Select One:");
            System.out.println("------------------");
            System.out.println("A.Display All Entries");
            System.out.println("D.Display All Deposits");
            System.out.println("P.Display All Payments");
            System.out.println("R.Reports");


            choice = scanner.nextLine().trim();


            switch (choice.toUpperCase()) {
                case "A":

                    displayALl();
                    System.out.println("Press any key to continue or X to exit.");
                    choice = scanner.nextLine().trim();
                    break;

                case "D":
                    displayDeposits();
                    System.out.println("Press any key to continue or X to exit.");
                    choice = scanner.nextLine().trim();
                    break;

                case "P":
                    displayPayments();
                    System.out.println("Press any key to continue or X to exit.");
                    choice = scanner.nextLine().trim();
                    break;

                case "R":
                    //reports();
                    System.out.println("Reports");
                    System.out.println("Press any key to continue or X to exit.");
                    choice = scanner.nextLine().trim();
                    break;


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
        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader br = new BufferedReader(fileReader);
        String input;
        while ((input = br.readLine()) != null) {
            System.out.println(input);


        }
        br.close();


    }

    public static void displayDeposits() {
        // This method should display a table of all deposits in the `transactions` ArrayList.
        // The table should have columns for date, time, vendor, and amount.
        // The total amount of all deposits should be displayed at the bottom of the table.
        System.out.println("Here Are All Deposits:");
        System.out.println("----------------------");

    }

    public static void displayPayments() {
        // This method should display a table of all payments in the `transactions` ArrayList.
        // The table should have columns for date, time, vendor, and amount.
        // The total amount of all payments should be displayed at the bottom of the table.
        System.out.println("Here Are All Payments:");
        System.out.println("---------------------:");


    }
}


   /* private static void reportsMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Reports");
            System.out.println("Choose an option:");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    // Generate a report for all transactions within the current month,
                    // including the date, vendor, and amount for each transaction.
                    // The report should include a total of all transaction amounts for the month.
                case "2":
                    // Generate a report for all transactions within the previous month,
                    // including the date, vendor, and amount for each transaction.
                    // The report should include a total of all transaction amounts for the month.
                case "3":
                    // Generate a report for all transactions within the current year,
                    // including the date, vendor, and amount for each transaction.
                    // The report should include a total of all transaction amounts for the year.

                case "4":
                    // Generate a report for all transactions within the previous year,
                    // including the date, vendor, and amount for each transaction.
                    // The report should include a total of all transaction amounts for the year.
                case "5":
                    // Prompt the user to enter a vendor name, then generate a report for all transactions
                    // with that vendor, including the date, vendor, and amount for each transaction.
                    // The report should include a total of all transaction amounts for the vendor.
                case "0":
                    running = false;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }


    private static void filterTransactionsByDate(LocalDate startDate, LocalDate endDate) {
        // This method filters the transactions by date and prints a report to the console.
        // It takes two parameters: startDate and endDate, which represent the range of dates to filter by.
        // The method loops through the transactions list and checks each transaction's date against the date range.
        // Transactions that fall within the date range are printed to the console.
        // If no transactions fall within the date range, the method prints a message indicating that there are no results.
    }

    private static void filterTransactionsByVendor(String vendor) {
        // This method filters the transactions by vendor and prints a report to the console.
        // It takes one parameter: vendor, which represents the name of the vendor to filter by.
        // The method loops through the transactions list and checks each transaction's vendor name against the specified vendor name.
        // Transactions with a matching vendor name are printed to the console.
        // If no transactions match the specified vendor name, the method prints a message indicating that there are no results.
    }
}
*/










