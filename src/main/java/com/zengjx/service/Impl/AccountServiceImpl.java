package com.zengjx.service.Impl;

import com.zengjx.dao.AccountDao;
import com.zengjx.domain.Account;
import com.zengjx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 账号的实现类
 */
@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {
@Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
        System.out.println("业务层：查询所有的帐户...");
        List<Account> accounts = accountDao.findAll();
       // System.out.println(" acount="+accounts);
        //  return accountDao.findAll();
        return accounts;
    }

    public void saveAccount(Account account) {
        System.out.println("业务层：保存帐户...");
        accountDao.saveAccount(account);
    }

}