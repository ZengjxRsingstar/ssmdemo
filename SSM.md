#  SSM 整合
### 目标
学会使用SSM框架进行开发，完成从页面到数据库的新增、查询功能

### 【操作】

（1）开发准备

第一步：创建web工程

第二步：导入jar包

第三步：创建实体类

第四步：创建Dao

第五步：创建Service

第六步：创建Controller

（2）搭建Spring的环境

第一步：applicationContext.xml

第二步：log4j.properties文件

第三步：AccountService.java

第四步：测试类

（3）搭建SpringMVC环境

第一步：web.xml

第二步：springmvc.xml

第三步：AccountController.java

第四步：index.jsp

第五步：success.jsp（WEB-INF/pages/success.jsp）

（4）Spring整合SpringMVC框架

第一步：web.xml

第二步：AccountController.java（注入Service）

（5）Mybatis框架

第一步：sqlMapConfig.xml

第二步：AccountDao.java（AccountDao.xml）

第三步：测试TestMybatis.java

（6）Spring整合Mybatis框架

第一步：applicationContext.xml（重点）

第二步：AccountDao.java

第三步：TestSpringMybatis.java

第四步：AccountServiceImpl.java

第五步：AccountController.java

第六步：success.jsp

（7）配置Spring的声明式事务处理

第一步：applicationContext.xml

第二步：index.jsp（新增表单）

第三步：AccountController.java（保存）
# 整合思路

（1）：先搭建整合的环境

 

（2）：先把Spring的配置搭建完成

 

（3）：再使用Spring整合SpringMVC框架

 

（4）：最后使用Spring整合MyBatis框架
### 创建数据库表结构
```sql
create database itcastspringmvc;
use itcastspringmvc;
create table account(
    id int primary key auto_increment,
    name varchar(20),
    money double
);
```
###  创建maven 工程
### 2.2.2 **第二步：导入jar包**

```xml
<packaging>war</packaging>
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <spring.version>5.0.2.RELEASE</spring.version>
    <slf4j.version>1.6.6</slf4j.version>
    <log4j.version>1.2.12</log4j.version>
    <mysql.version>5.1.6</mysql.version>
    <mybatis.version>3.4.5</mybatis.version>
</properties>

<dependencies>

    <!-- spring -->
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.6.8</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aop</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-tx</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>${mysql.version}</version>
    </dependency>

    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>servlet-api</artifactId>
        <version>2.5</version>
        <scope>provided</scope>
    </dependency>

    <dependency>
        <groupId>javax.servlet.jsp</groupId>
        <artifactId>jsp-api</artifactId>
        <version>2.0</version>
        <scope>provided</scope>
    </dependency>

    <dependency>
        <groupId>jstl</groupId>
        <artifactId>jstl</artifactId>
        <version>1.2</version>
    </dependency>

    <!-- log start -->
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>${log4j.version}</version>
    </dependency>

    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>${slf4j.version}</version>
    </dependency>

    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-log4j12</artifactId>
        <version>${slf4j.version}</version>
    </dependency>
    <!-- log end -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>${mybatis.version}</version>
    </dependency>

    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>1.3.0</version>
    </dependency>

    <dependency>
        <groupId>c3p0</groupId>
        <artifactId>c3p0</artifactId>
        <version>0.9.1.2</version>
        <type>jar</type>
        <scope>compile</scope>
    </dependency>

</dependencies>

<build>
    <finalName>ssm</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.2</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>UTF-8</encoding>
                    <showWarnings>true</showWarnings>
                </configuration>
            </plugin>
        </plugins>
</build>
```
创建包com.zengjx.ssm.domain，创建类Account.java

```java
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;
}
```
###  **第四步：创建Dao**

创建包com.zengjx.ssm.dao，创建类AccountDao.java

【步骤】

查询所有findAll方法

新增saveAccount方法
```java
/**
 * AccountMapper接口，不用编写实现类，框架生成代理对象
 */
public interface AccountDao {

    public List<Account> findAll();

    public void saveAccount(Account account);

}
```

###  **第五步：创建Service**

创建包com.zengjx.ssm.service，创建接口AccountService.java

```java
public interface AccountService {

    public List<Account> findAll();

    public void saveAccount(Account account);


}
```
### 创建类AccountServiceImpl，实现接口

```java
/**
 * 账号的实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public List<Account> findAll() {
        System.out.println("业务层：查询所有的帐户...");
        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("业务层：保存帐户...");
        accountDao.saveAccount(account);
    }

}
```

### 创建类AccountServiceImpl，实现接口

```java
/**
 * 账号的实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public List<Account> findAll() {
        System.out.println("业务层：查询所有的帐户...");
        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("业务层：保存帐户...");
        accountDao.saveAccount(account);
    }

}
```
 

###  **第六步：创建Controller**

创建包com.zengjx.ssm.controller，创建类AccountController.java

```java
/**
 * 帐户
 */
public class AccountController {

    private AccountService accountService;

    /**
     * 查询所有
     * @return
     */
    public String findAll() {
        System.out.println("表现层：查询所有账户...");
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        return "success";
    }

    /**
     * 保存
     * @return
     */
    public String saveAccount(Account account) {
System.out.println("表现层：保存账户...");
        accountService.saveAccount(account);
        return "success";
    }

}
```
##  **搭建Spring的环境**

### 2.3.1 **applicationContext.xml**

在项目中的resources文件夹下创建applicationContext.xml的配置文件，编写具体的配置信息。

【路径 】：配置组件扫描

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
   http://www.springframework.org/schema/beans/spring-beans.xsd
   http://www.springframework.org/schema/context
   http://www.springframework.org/schema/context/spring-context.xsd
   http://www.springframework.org/schema/aop
   http://www.springframework.org/schema/aop/spring-aop.xsd
   http://www.springframework.org/schema/tx 
   http://www.springframework.org/schema/tx/spring-tx.xsd">
    <!-- 开启注解扫描 -->
    <context:component-scan base-package="com.zengjx.ssm">
        <!-- 忽略某些注解，把Controller给忽略了 -->
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
</beans>
```