package com.thom.cs.database;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class DataBase {
    private String pathname;

    public abstract void updateData();
}