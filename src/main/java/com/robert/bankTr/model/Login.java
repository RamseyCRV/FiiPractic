package com.robert.bankTr.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Login {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    public Login(String name, String passwd) {
        username = name;
        password = passwd;
    }
}