package com.yearup;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Capstone {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        homeScreen(scanner);
        scanner.close();

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


                    choice = scanner.nextLine().trim();


                    switch (choice.toUpperCase()) {
                        case "D":
                            depositInfo(scanner);

                            break;

                        case "P":
                            payment(scanner);

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
        }

    }

   //* private static ArrayList<transactions> getInventory() {
    //    ArrayList<transactions> inventory = new ArrayList<>();
    //  String storeInventory = "transaction.csv";
    //try {
    //  BufferedReader br = new BufferedReader(new FileReader(storeInventory));
    // String line;
    //        while ((line = br.readLine()) != null) {
    //          String[] parts = line.split("\\|");
    //        String id = parts[0];
    //      String name = parts[1];
    //    Double price = Double.parseDouble(parts[2]);
    //            inventory.add(new transactions(id, name, price));
    //       }
    //        br.close();

    //    } catch (Exception e) {

        //}
        //return inventory;
   // }

    public static void depositInfo(Scanner scanner){
        System.out.println("Make A Deposit");
        System.out.println("Please Input Deposit Information");
        String info = scanner.nextLine();
try {


        FileWriter file = new FileWriter("transactions.csv");
        file.write(info);
        file.close();


}

catch(Exception e) {

    e.printStackTrace();
}


    }
    public static void payment(Scanner scanner){
        System.out.println("Make A Payment");
        System.out.println("Please Input ");
        String pInfo = scanner.nextLine();

    }
    public static void ledger(Scanner scanner){
        System.out.println("Welcome to Ledger");
        System.out.println("Please Input Information");
        String lInfo = scanner.nextLine();

    }

}




