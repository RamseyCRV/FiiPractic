package com.robert.bankTr.tran;

import com.robert.bankTr.model.Transaction;
import com.robert.bankTr.model.User;

public interface MakeTran {
    Transaction makeTransaction(User from,User to,Transaction amount) throws Exception;
}
