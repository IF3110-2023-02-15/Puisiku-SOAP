package com.chagiya.repositories;

import com.chagiya.database.MySQL;

import java.sql.Connection;

public class Repository {
    protected final Connection conn;

    public Repository() {
        MySQL db = new MySQL();
        conn = db.getConnection();
    }
}
