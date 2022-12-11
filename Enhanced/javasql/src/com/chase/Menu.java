//============================================================================
// Name        : Menu.java
// Author      : Chase Outman
// Version     : 1.0
// Description : Menu class that will display user options and performs those operations
//============================================================================
package com.chase;


import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    public static void userChoice() {
        //Scanner objects to read user input

        int userChoice = 0;

        //While loop to continue until user enters a 9
        while (userChoice != 9) {
            displayMenu();
            userChoice = getUserInput("Enter a choice: ", "not a valid number!");

            switch (userChoice) {
                case 1:
                    Database.initDatabase();
                    break;
                case 2:
                    Database.printData();
                    break;
                case 3:
                    String bid = Integer.toString(getUserInput("Enter a bid id: ", "not a valid bid id!"));
                    Database.findBid(bid);
                    break;
                case 4:
                    String removeBid = Integer.toString(getUserInput("Enter bid ID to remove: ", "not a valid bid id!"));
                    Database.removeBid(removeBid);
                    break;
                case 9:
                    //ends the program
                    System.out.println("Exiting Application!");
                    break;
                default:
                    //default case
                    System.out.println("Not a Valid Choice!");
                    break;
            }
        }

    }
    //function that outputs the menu options
    private static void displayMenu() {

        System.out.println("Menu:");
        System.out.println("  1. Load Bids");
        System.out.println("  2. Display All Bids");
        System.out.println("  3. Find Bids");
        System.out.println("  4. Remove Bids");
        System.out.println("  9. Exit");

    }

    private static int getUserInput(String message, String error) {
        int userInput;
        System.out.print(message);
        //simple input validation that stops program from crashing if invalid input is put in
        while (!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.println(input + " " + error);
            System.out.print(message);
        }
        //gets the users input
        userInput = scanner.nextInt();
        return userInput;
    }

}
