package com.chagiya.services.implementors;

import com.chagiya.models.LoggingModel;
import com.chagiya.repositories.LoggingRepository;
import com.chagiya.services.interfaces.LoggingService;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoggingServiceImpl implements LoggingService {
    @Override
    public void log(String email) {
        String description = "Email " + email + " logged!";
        String ipAddress = "0.0.0.0";
        String endpoint = "subscription";
        String requester = "subscriber";

        LoggingModel lm = new LoggingModel(description, ipAddress, endpoint, requester);

        LoggingRepository lr = new LoggingRepository();
        lr.addLogging(lm);
    }
}

