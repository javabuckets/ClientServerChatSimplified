package com.thom.cs.database;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDataBase extends DataBase {
    public ArrayList<String> usernames = new ArrayList<String>();
    public ArrayList<String> passwords = new ArrayList<String>();

    public UserDataBase() {

    }

    @Override
    /**
     * Reads the data (if any) from the server machine and loads it to the database
     */
    public void updateData() {
        try {
            DataWriter dw = new DataWriter();

            // If the "users" database directory exists
            if (dw.dr.doesDatabaseDirectoryExist("users")) {
                // If the "database_user" database file exists
                if (dw.dr.doesDatafileExist("database_user", "users")) {
                    /**
                     * Check if the datafile is empty (no entries)
                     * If not empty, load the data (if its valid) to the database
                     * If its not valid, throw an error (and maybe delete the invalid?)
                     */
                    if (!dw.dr.isDatafileEmpty("database_user", "users")) {
                        File file = new File("./dbs/users/database_user");

                        for (int i = 0; i < dw.dr.getFileContents(file).size(); i++) {
                            if (dw.dr.readLine(file, i).contains(";")) {
                                String user = dw.dr.readLine(file, i).substring(0, (dw.dr.readLine(file, i).indexOf(";")));
                                String pass = dw.dr.readLine(file, i).substring(dw.dr.readLine(file, i).indexOf(";") + 1, dw.dr.readLine(file, i).length());

                                // Stores the users from the database to the list
                                store(user, pass, false);
                            }
                        }
                    } else {
                        System.out.println("Datafile 'database_user' is empty");
                    }
                } else {
                    dw.createDatafile("database_user", "users");
                }
            } else {
                // Creates the directory if it doesn't exist and calls the method itself again, so as to create the database file
                dw.createDatabaseDirectory("users");
                updateData();
            }
        } catch (IOException e) {
            System.err.println("Something went wrong upon database data updating!");
            e.printStackTrace();
        }
    }

    /**
     * Stores a given user and pass to the ArrayList of usernames and passwords.
     * Also stores the data locally if account doesn't already exist
     *
     * @param user Username to store
     * @param pass Password to store
     * @param flag If true; The dataset will be stored locally as well
     * @return Returns true if the storing was accepted and false if the user already exists.
     */
    public boolean store(String user, String pass, boolean flag) {
        if (usernames.contains(user)) {
            return false;
        } else {
            if (flag) {
                storeLocally(user, pass);
            }

            usernames.add(user);
            passwords.add(pass);

            return true;
        }
    }

    /**
     * Stores a given user and pass dataset to the disk in the database for user accounts.
     *
     * @param user Username to store
     * @param pass Password to store
     */
    public void storeLocally(String user, String pass) {
        try {
            DataWriter dw = new DataWriter();
            String dataset = user + ";" + pass;
            dw.writeLine("./dbs/users/database_user", dataset);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * If user password access is required (still encrypted), then use this.
     *
     * @return Returns a List of HashMaps that contains the user's username and password (username is key)
     * @throws IOException
     */
    public List<HashMap<String, String>> getUserEntries() throws IOException {
        DataWriter dw = new DataWriter();
        File file = new File("./dbs/users/database_user");

        List<HashMap<String, String>> entryList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < dw.dr.getFileContents(file).size(); i++) {
            if (dw.dr.readLine(file, i).contains(";")) {
                String user = dw.dr.readLine(file, i).substring(0, (dw.dr.readLine(file, i).indexOf(";")));
                String pass = dw.dr.readLine(file, i).substring(dw.dr.readLine(file, i).indexOf(";") + 1, dw.dr.readLine(file, i).length());

                HashMap<String, String> map = new HashMap<String, String>();
                map.put(user, pass);
                entryList.add(map);
            }
        }
        return entryList;
    }

    /**
     * Gets the specific HashMap in the List of HashMaps.
     *
     * @param index The index in the List
     * @return Returns a HashMap from a List of HashMaps
     * @throws IOException
     */
    public HashMap<String, String> getUserEntry(int index) throws IOException {
        return getUserEntries().get(index);
    }
}