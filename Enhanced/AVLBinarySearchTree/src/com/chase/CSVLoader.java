//============================================================================
// Name        : CSVLoader.java
// Author      : Chase Outman
// Version     : 1.0
// Description : Loads data from a CSV file into an AVL tree or a HashMap.
//============================================================================
package com.chase;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class CSVLoader {

    public AVLTree loadBids(String path, AVLTree tree) {
        System.out.println("Loading CSV File " + path);

        String data[];
        String currentLine;
        String delimiter = ",";
        int bidIdCol = 1;
        int titleCol = 0;
        int fundCol = 8;
        int amountCol = 4;

        try {
            //loads the csv file into a buffered reader to read contents of the file
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream is = classLoader.getResourceAsStream(path);
            InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(streamReader);

            // removes the first line of the CSV file or the header line
            String headerLine = br.readLine();
            //while loop that reads each line of the csv file
            while ((currentLine = br.readLine()) != null) {
                Bid bid = new Bid();
                data = currentLine.split(delimiter);
                //sets value for each bid variables
                bid.setBidId(data[bidIdCol]);
                bid.setTitle(data[titleCol]);
                bid.setFund(data[fundCol]);
                bid.setAmount(data[amountCol]);

                //inserts the bid object into the AVL tree
                tree.insert(bid);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return tree;

    }

    public HashMap<String, Bid> loadBids(String path, HashMap<String, Bid> map) {
        System.out.println("Loading CSV File " + path);

        String data[];
        String currentLine;
        String delimiter = ",";
        int bidIdCol = 1;
        int titleCol = 0;
        int fundCol = 8;
        int amountCol = 4;

        try {
            //loads the csv file into a buffered reader to read contents of the file
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream is = classLoader.getResourceAsStream(path);
            InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(streamReader);

            // removes the first line of the CSV file or the header line
            String headerLine = br.readLine();
            //while loop that reads each line of the csv file
            while ((currentLine = br.readLine()) != null) {
                Bid bid = new Bid();
                data = currentLine.split(delimiter);
                //sets value for each bid variables
                bid.setBidId(data[bidIdCol]);
                bid.setTitle(data[titleCol]);
                bid.setFund(data[fundCol]);
                bid.setAmount(data[amountCol]);

                //inserts the bid object into the AVL tree
                map.put(bid.getBidId(),bid);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return map;

    }

}
