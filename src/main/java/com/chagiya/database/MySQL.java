package com.chagiya.database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.Getter;

public class MySQL {
    @Getter
    private final Connection connection;

    public MySQL() {
        try {
            Dotenv dotenv = Dotenv.load();

            String host = dotenv.get("MYSQL_HOST");
            String port = dotenv.get("MYSQL_PORT");
            String database = dotenv.get("MYSQL_DATABASE");
            String user = dotenv.get("MYSQL_USER");
            String password = dotenv.get("MYSQL_PASSWORD");

            String url = String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s&useSSL=false&allowPublicKeyRetrieval=true", host, port, database, user, password);
            this.connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
