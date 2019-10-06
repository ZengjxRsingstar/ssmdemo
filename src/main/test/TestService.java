import com.zengjx.domain.Account;
import com.zengjx.service.AccountService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import sun.security.util.Resources;

import java.io.InputStream;
import java.util.List;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author zengjx
 * @Company zengjx
 * @Date 2019/10/2  0:02
 * @Version V1.0
 */
public class TestService {

@Test
 public  void   testService(){
    ApplicationContext  ac =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    AccountService accountService =(AccountService) ac.getBean("accountService");

    //插入
    Account  account  =new Account();
    account.setName("ccc");
    account.setMoney(2323d);

    accountService.saveAccount(account);


    List<Account> accounts = accountService.findAll();
    for (Account account1 : accounts) {
        System.out.println(account1);
    }



}



}
