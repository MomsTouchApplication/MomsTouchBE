package com.momstouch.momstouchbe.domain.member.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
//@Builder
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    private String loginId;
    private String password;
    private String name;
    private String role;

    @Builder
    private Account(String loginId, String password, String name, String role) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;

        if(!role.startsWith("ROLE_")) {
            throw new IllegalArgumentException();
        }

        this.role = role;
    }
}
