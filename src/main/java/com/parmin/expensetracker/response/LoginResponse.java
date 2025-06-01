package com.parmin.expensetracker.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {

    private String token;

    private Long expiryTime;

}
