package com.chagiya.repositories;

import com.chagiya.models.SubscriptionModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubscriptionRepository extends Repository {
    public void addLogging(SubscriptionModel sm) {
        String query = "INSERT INTO subscription (email, creatorId) VALUES(?, ?)";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            pstmt.setString(1, sm.getEmail());
            pstmt.execute();
            pstmt.close();
            this.conn.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}