package com.chagiya.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@NonNull
@AllArgsConstructor
public class SubscriptionModel {
    private final String email;
}