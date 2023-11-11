package com.chagiya.repositories;

import com.chagiya.models.SubscriptionModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriptionRepository extends Repository {
    public void subscribe(SubscriptionModel sm) {
        String query = "INSERT INTO subscription (email, creatorId) VALUES(?, ?)";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            pstmt.execute();
            pstmt.close();
            this.conn.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int getSubscriberCount(int creatorId) {
        int subscriberCount = 0;
        String query = "SELECT COUNT(*) AS count FROM subscription WHERE creatorId = ?";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            pstmt.setInt(1, creatorId);

            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                subscriberCount = resultSet.getInt("count");
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscriberCount;
    }
}