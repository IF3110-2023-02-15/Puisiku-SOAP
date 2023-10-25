package com.chagiya.repositories;

import com.chagiya.models.LoggingModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoggingRepository extends Repository {
    public void addLogging(LoggingModel lm) {
        String query = "INSERT INTO logs (description, ip_address, endpoint, requester) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            pstmt.setString(1, lm.getDescription());
            pstmt.setString(2, lm.getIpAddress());
            pstmt.setString(3, lm.getEndpoint());
            pstmt.setString(4, lm.getRequester());
            pstmt.execute();
            pstmt.close();
            this.conn.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
