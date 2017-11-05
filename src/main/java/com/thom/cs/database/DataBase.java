package com.thom.cs.database;

public abstract class DataBase {
    public String pathname;

    public DataBase() {

    }

    public abstract void updateData();

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    public String getPathname() {
        return pathname;
    }
}