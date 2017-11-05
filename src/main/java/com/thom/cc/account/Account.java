package com.thom.cc.account;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.beans.ConstructorProperties;
import java.util.ArrayList;

@Data
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Account {
    @NonNull private String username;
    @NonNull private String password;
    private final ArrayList<Account> friendList = new ArrayList<Account>();
}