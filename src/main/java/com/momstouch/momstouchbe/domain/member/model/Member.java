package com.momstouch.momstouchbe.domain.member.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Data
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String email; //가입 이메일

    @Embedded
    private Account account;

    public static Member createMember(String loginId, String password, String name, String role) {
        return Member.builder()
                .account(Account.builder()
                        .loginId(loginId)
                        .password(password)
                        .name(name)
                        .role(role)
                        .build())
                //TODO: 수정
                .email("email")
                .build();
    }
    public String getRole(){
        return account.getRole();
    }

    public Member update(String name){
        return Member.builder()
                .account(Account.builder()
                        .name(name)
                        .build())
                .build();
    }


    public String getName() {
        return  account.getName();
    }

    public boolean equals(Authentication authentication) {
        return account.equals(authentication);
    }


}
