import com.zengjx.dao.AccountDao;
import com.zengjx.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author zengjx
 * @Company zengjx
 * @Date 2019/10/2  14:45
 * @Version V1.0
 */
public class TestSpringMybatis {

  @Test
 public   void   testMybatis(){
      ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
      AccountDao  accountDao  =ac.getBean(AccountDao.class);
      List<Account> accountList = accountDao.findAll();
      for (Account account : accountList) {
          System.out.println(" acount="+account);
      }

  }


}
