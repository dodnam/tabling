package com.nam.tabling.domain.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Admin {
    private long id;

    private String email;
    private String nickname;
    private String password;
    private String phoneNumber;
    private String memo;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


}
