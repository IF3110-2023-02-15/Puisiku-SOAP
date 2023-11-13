package com.chagiya.repositories;

import com.chagiya.models.SubscriptionModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionRepository extends Repository {
    public void subscribe(SubscriptionModel sm) throws Exception{
        String query = "INSERT INTO subscription (email, creatorId) VALUES(?, ?)";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            pstmt.setString(1, sm.getEmail());
            pstmt.setInt(2, sm.getCreatorId());
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e){
            e.printStackTrace();
            throw new Exception("An error occurred during subscribe");
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

    public List<Integer> getSubscribedCreators(String email) throws Exception {
        List<Integer> creatorIds = new ArrayList<>();

        String query = "SELECT DISTINCT creatorId FROM subscription WHERE email = ?";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            pstmt.setString(1, email);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                creatorIds.add(resultSet.getInt("creatorId"));
            }

            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("An error occurred during getting subscribed creators");
        }

        return creatorIds;
    }

}