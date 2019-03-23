package com.robert.bankTr.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;


    private Long fromUser;
    private Long toUser;
    private Double amount;



}
