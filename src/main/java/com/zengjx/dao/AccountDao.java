package com.zengjx.dao;

import com.zengjx.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AccountMapper接口，不用编写实现类，框架生成代理对象
 *
 */
@Repository
public interface AccountDao {
    @Select(value = "select  * from account ")
    public List<Account> findAll();
    @Insert(value = "insert  into account (name,money)values (#{name},#{money})")
    public void saveAccount(Account account);

}