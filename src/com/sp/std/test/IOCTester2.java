package com.sp.std.test;


import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;


public class IOCTester2 {
    //测试数据库连接池
    ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/conf/applicationContext4.xml");
    @Test
    public void test() throws SQLException {
        //测试spring 管理数据源
        DataSource dataSource = (DataSource)applicationContext.getBean("dataSource");
        //下面这种方式只适合只有一个数据源的情况
        //DataSource dataSource2 = (DataSource)applicationContext.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
        // 打印 com.mchange.v2.c3p0.impl.NewProxyConnection@6f03482  说明数据库连接成功
//        信息: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 3, acquireRetryAttempts -> 30, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> false, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, dataSourceName -> 1br3qipam1ldakfnuqm3gk|61df66b6, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.mysql.cj.jdbc.Driver, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, identityToken -> 1br3qipam1ldakfnuqm3gk|61df66b6, idleConnectionTestPeriod -> 0, initialPoolSize -> 3, jdbcUrl -> jdbc:mysql://192.168.217.128:3306/test, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 15, maxStatements -> 0, maxStatementsPerConnection -> 0, minPoolSize -> 3, numHelperThreads -> 3, preferredTestQuery -> null, properties -> {user=******, password=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
//        com.mchange.v2.c3p0.impl.NewProxyConnection@6f03482
       /****
        org.springframework.beans.factory.BeanCreationException:
        Error creating bean with name 'dataSource' defined in class
        path resource [conf/applicationContext4.xml]:
        Instantiation of bean failed; nested exception is j
        ava.lang.NoClassDefFoundError: com/mchange/v2/ser/Indirector
       ***/
       //在配置c3p0 的数据库配置文件时 如果使用 com.mysql.jdbc.Driver  会提示如下信息
       //新的c3p0 的数据库连接池配置 要修改为 com.mysql.cj.jdbc.Driver
       //Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
    }

}
