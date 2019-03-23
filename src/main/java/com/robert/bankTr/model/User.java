package com.robert.bankTr.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@Entity
public class User {

    @Id @GeneratedValue

    private Long id;
    private String name;
    private Double amount;

    public User(String name, Double amount){
        this.name=name;
        this.amount=amount;
    }
}
