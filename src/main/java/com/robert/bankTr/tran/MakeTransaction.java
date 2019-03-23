package com.robert.bankTr.tran;

import com.robert.bankTr.model.Transaction;
import com.robert.bankTr.model.User;
import com.robert.bankTr.repository.TransactionRepository;
import com.robert.bankTr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional(rollbackOn = Exception.class)
public class MakeTransaction implements MakeTran{

    public static final int TEN_THOUSAND=10000;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;

    private void substractAmount(User u,Double amount) throws Exception{
        u.setAmount(u.getAmount() - amount);
        userRepository.save(u);
        userRepository.flush();
    }

    private void addAmount(User u,Double amount){
        u.setAmount(u.getAmount() + amount);
        userRepository.save(u);
        userRepository.flush();
    }

    @Override
    public Transaction makeTransaction(User from, User to, Transaction transaction) throws Exception {
        final Double amount= transaction.getAmount();
        substractAmount(from,amount);
        addAmount(to,amount);
        transaction.setFromUser(from.getId());
        transaction.setToUser(to.getId());
        return persistTransactionsLessThanFiveHoundred(transaction);
    }
    private Transaction persistTransactionsLessThanFiveHoundred(Transaction t){
        if(t.getAmount() < TEN_THOUSAND){
            transactionRepository.save(t);
        }
        return null;
    }
}
