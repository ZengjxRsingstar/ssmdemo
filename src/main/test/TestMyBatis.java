import com.zengjx.dao.AccountDao;
import com.zengjx.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author zengjx
 * @Company zengjx
 * @Date 2019/10/2  11:55
 * @Version V1.0
 */
public class TestMyBatis {

@Test
 public   void   testMyBatis()  throws   Exception{

    InputStream   inputStream  = Resources.getResourceAsStream("sqlMappingConfig.xml") ;
    SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession session = build.openSession();
    AccountDao accountDao = session.getMapper(AccountDao.class);
    List<Account> accountList = accountDao.findAll();
    for (Account account : accountList) {
        System.out.println(account);
    }

     session.close();
    inputStream.close();
}
}
