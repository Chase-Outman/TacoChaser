--SQL script to create a the ebay_records database and also create the ebay_bids table

DROP DATABASE IF EXISTS ebay_records;
CREATE DATABASE ebay_records;
USE ebay_records;

CREATE TABLE ebay_records.ebay_bids (
             bid_id INT NOT NULL,
             title VARCHAR(100) NULL,
             fund VARCHAR(45) NULL,
             bid_amount VARCHAR(15) NULL,
             PRIMARY KEY (bid_id));