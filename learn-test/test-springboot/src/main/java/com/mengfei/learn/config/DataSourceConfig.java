package com.mengfei.learn.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 统一配置多数据源的连接池
 */

@Configuration
public class DataSourceConfig {
    //private Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    //region 配置属性

    @Value("${spring.datasource.demo.url}")
    private String dbUrlSystem;
    @Value("${spring.datasource.demo.username}")
    private String usernameSystenm;
    @Value("${spring.datasource.demo.password}")
    private String passwordSystem;

    @Value("${spring.datasource.demo2.username}")
    private String usernameEvent;
    @Value("${spring.datasource.demo2.password}")
    private String passwordEvent;
    @Value("${spring.datasource.demo2.url}")
    private String dbUrlEvent;

    @Value("com.mysql.cj.jdbc.Driver")
    private String driverClassName;

    @Value("5")
    private int initialSize;

    @Value("5")
    private int minIdle;

    @Value("20")
    private int maxActive;

    @Value("60000")
    private int maxWait;

    /**
     * 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
     */
    @Value("60000")
    private int timeBetweenEvictionRunsMillis;

    /**
     * 配置一个连接在池中最小生存的时间，单位是毫秒
     */
    @Value("300000")
    private int minEvictableIdleTimeMillis;

    @Value("SELECT 1 FROM DUAL")
    private String validationQuery;

    @Value("true")
    private boolean testWhileIdle;

    @Value("false")
    private boolean testOnBorrow;

    @Value("false")
    private boolean testOnReturn;

    /**
     * 打开PSCache，并且指定每个连接上PSCache的大小
     */
    @Value("true")
    private boolean poolPreparedStatements;

    @Value("20")
    private int maxPoolPreparedStatementPerConnectionSize;

    /**
     * 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
     */
    @Value("stat,wall,log4j")
    private String filters;

    /**
     * 通过connectProperties属性来打开mergeSql功能；慢SQL记录
     */
    @Value("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500")
    private String connectionProperties;

    //endregion

    @Primary
    @Bean(name = "demoDataSource")
    @Qualifier("demoDataSource")
    public DataSource demoDataSource(){
        DataSource ds= getDruidDataSource(usernameSystenm, passwordSystem, dbUrlSystem,"demoDataSource");
        return ds;
    }

    @Bean(name = "demo2DataSource")
    @Qualifier("demo2DataSource")
    public DataSource demo2DataSource(){
        DataSource ds=getDruidDataSource(usernameEvent, passwordEvent, dbUrlEvent,"demo2DataSource");
        return ds;
    }

    /**
     * JdbcTemplate支持
     * @author lyd
     * @date 2017年8月3日
     * @param dataSource
     * @return
     */
    @Bean(name = "demoJdbcTemplate")
    public JdbcTemplate demoJdbcTemplate(
            @Qualifier("demoDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "demo2JdbcTemplate")
    public JdbcTemplate demo2JdbcTemplate(
            @Qualifier("demo2DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * 非JTA事务
     * @param username
     * @param password
     * @param url
     * @param datasourceName
     * @return
     */
    /*private DruidDataSource getDruidDataSource(String username, String password, String url,String datasourceName) {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            //添加日志
        }
        datasource.setConnectionProperties(connectionProperties);

        return datasource;
    }*/

    /**
     * JTA事务MysqlXA版本
     * @param username
     * @param password
     * @param url
     * @param datasourceName
     * @return
     */
    /*private DataSource getDruidDataSource(String username, String password, String url,String datasourceName) {
        MysqlXADataSource mysqlXADataSource=new MysqlXADataSource();
        mysqlXADataSource.setUrl(url);
        //mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(password);
        mysqlXADataSource.setUser(username);


        AtomikosDataSourceBean xaDataSource=new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName(datasourceName);

        xaDataSource.setMinPoolSize(minIdle);
        xaDataSource.setMaxPoolSize(maxActive);

        *//*<property name="poolSize" value="10" />
        <property name="minPoolSize" value="10"/>
        <property name="maxPoolSize" value="30"/>
        <property name="borrowConnectionTimeout" value="60"/>  <!--获取连接失败重新获等待最大时间，在这个时间内如果有可用连接，将返回-->
        <property name="reapTimeout" value="20"/> <!--最大获取数据时间，如果不设置这个值，Atomikos使用默认的5分钟，那么在处理大批量数据读取的时候，一旦超过5分钟，就会抛出类似 Resultset is close 的错误.-->
        <property name="maxIdleTime" value="60"/>    <!--最大闲置时间，超过最小连接池连接的连接将将关闭-->
        <property name="maintenanceInterval" value="60" />  <!--连接回收时间-->
        <property name="loginTimeout" value="60" />     <!--java数据库连接池，最大可等待获取datasouce的时间-->
        <property name="logWriter" value="60"/>
        <property name="testQuery">
            <value>select 1</value>
        </property>*//*


        return xaDataSource;
    }*/


    /**
     * JTA事务DruidXA版本
     * @param username
     * @param password
     * @param url
     * @param datasourceName
     * @return
     * @throws Exception
     */
    private DataSource getDruidDataSource(String username, String password, String url,String datasourceName){
        DruidXADataSource druidXADataSource = new DruidXADataSource();
        druidXADataSource.setUrl(url);
        druidXADataSource.setUsername(username);
        druidXADataSource.setPassword(password);
        druidXADataSource.setMinIdle(minIdle);
        druidXADataSource.setMaxActive(maxActive);
        druidXADataSource.setInitialSize(initialSize);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setUniqueResourceName(datasourceName);
        xaDataSource.setXaDataSource(druidXADataSource);

        return xaDataSource;
    }
}
