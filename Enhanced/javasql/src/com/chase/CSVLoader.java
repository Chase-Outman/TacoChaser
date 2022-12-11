//============================================================================
// Name        : CSVLoader.java
// Author      : Chase Outman
// Version     : 1.0
// Description : Loads data from a CSV file into a local MySQL database
//============================================================================

package com.chase;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class CSVLoader {

    public static void loadBids(String path) {
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
                data = currentLine.split(delimiter);
                //sets value for each bid variables
                int bidId = Integer.parseInt(data[bidIdCol]);
                String title = data[titleCol];
                String fund = data[fundCol];
                String amount = data[amountCol];
                //function call that inserts the bid data into the database
                Database.insertData(bidId, title, fund, amount);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
