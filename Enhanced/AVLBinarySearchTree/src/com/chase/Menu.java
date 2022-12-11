//============================================================================
// Name        : Menu.java
// Author      : Chase Outman
// Version     : 1.0
// Description : Menu class that will display user options and performs those operations
//============================================================================
package com.chase;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    final static double MILLISECONDS_TO_SECONDS = 1.0 / 1000;
    static Scanner scanner = new Scanner(System.in);
    public static void userChoice() {

        //AVL tree initialized
        AVLTree tree = new AVLTree();
        int userChoice = 0;
        //Hashmap initialized
        HashMap<String, Bid> map = new HashMap<>();

        //While loop to continue until user enters a 9
        while (userChoice != 9) {
            displayMenu();

            userChoice = getUserInput("Enter a choice: ", "not a valid number!");

            switch (userChoice) {
                case 1:
                    loadDataToAVLTree(tree);
                    loadDataToHashMap(map);
                    break;
                case 2:
                    //outputs content of the AVL tree
                    try {
                        tree.print();
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    String bid = Integer.toString(getUserInput("Enter a bid id: ", "not a valid bid id!"));
                    findBidInAVLTree(tree, bid);
                    findBidInHashMap(map, bid);
                    break;
                case 4:
                    String removeBid = Integer.toString(getUserInput("Enter bid ID to remove: ", "not a valid bid id!"));
                    removeBidFromAVLTree(tree, removeBid);
                    removeBidFromHashMap(map, removeBid);
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
    //function that removes a specific bid from the hashmap
    private static void removeBidFromHashMap(HashMap<String, Bid> map, String removeBid) {
        //check to see if the bid exists in the hashmap, then removes the bid if it exists
        //else it outputs that the bid does not exist
        if (map.containsKey(removeBid)) {
            map.remove(removeBid);
            System.out.println("Bid " + removeBid + " has been removed from hashmap");
        }
        else {
            System.out.println("Bid " + removeBid + " does not exist in hashmap");
        }
    }
    //function to remove specific bid from the AVL tree
    private static void removeBidFromAVLTree(AVLTree tree, String removeBid) {
        tree.remove(removeBid);
    }
    //function that displays a message to get data from the user and can display an error if undesired data is entered
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

    private static void findBidInHashMap(HashMap<String, Bid> map, String bidID) {
        //start time for finding a specific bid
        long start = System.currentTimeMillis();
        //function call to search for bid id
        if (map.containsKey(bidID)) {
            System.out.println("Bid was found");
            System.out.println(map.get(bidID).getBidId() + " " +
                               map.get(bidID).getTitle() + " " +
                               map.get(bidID).getAmount());
        }
        else {
            System.out.println("Bid was not found in hashmap!");
        }
        //finsih time for finding a specific bid
        long finish = System.currentTimeMillis();
        //calculates the time to finish the searching of a bid
        outputTimeToComplete("Time to find bid in hashmap", start, finish);
    }
    //function that calculates the time it takes to complete a task
    private static void outputTimeToComplete(String message, long start, long finish) {
        long timeToFinish = finish - start;
        //outputs the time it took to find a bid in milliseconds and seconds
        System.out.println(message);
        System.out.println("Time: " + timeToFinish + " milliseconds");
        System.out.println("Time: " + timeToFinish * MILLISECONDS_TO_SECONDS + " seconds");
    }

    private static void findBidInAVLTree(AVLTree tree, String bidID) {

        //start time for finding a specific bid
        long start = System.currentTimeMillis();
        //function call to search for bid id
        tree.search(bidID);
        //finsih time for finding a specific bid
        long finish = System.currentTimeMillis();
        //calculates the time to finish the searching of a bid
        outputTimeToComplete("Time to find bid in AVL Tree", start, finish);
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

    private static void loadDataToAVLTree(AVLTree tree) {
        //get starting time for loading csv file
        long start = System.currentTimeMillis();

        //calls loader class to load csv file contents into the AVL tree
        String csvFile1 = "eBid_Monthly_Sales_Dec_2016.csv";
        String csvFile2 = "eBid_Monthly_Sales.csv";
        CSVLoader loader = new CSVLoader();
        loader.loadBids(csvFile1, tree);
        loader.loadBids(csvFile2, tree);

        //get finish time for loading csv file
        long finish = System.currentTimeMillis();
        outputTimeToComplete("Time to load data to AVL Binary Search Tree:", start, finish);
    }

    private static void loadDataToHashMap(HashMap<String, Bid> map) {
        //get starting time for loading csv file
        long start = System.currentTimeMillis();

        //calls loader class to load csv file contents into the AVL tree
        String csvFile1 = "eBid_Monthly_Sales_Dec_2016.csv";
        String csvFile2 = "eBid_Monthly_Sales.csv";
        CSVLoader loader = new CSVLoader();
        loader.loadBids(csvFile1, map);
        loader.loadBids(csvFile2, map);

        //get finish time for loading csv file
        long finish = System.currentTimeMillis();
        //calculates the time it took to load the csv file in to the AVL tree
        outputTimeToComplete("Time to load data to HashMap:", start, finish);
    }
}
