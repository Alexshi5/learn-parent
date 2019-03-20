package com.mengfei.learn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 一个多数据源事务的配置类2
 */

@Configuration
@EnableJpaRepositories(
        //basePackageClasses = 设置Repository所在的类
        basePackages = "com.mengfei.learn.mapper.demo2", //设置Repository所在的包
        entityManagerFactoryRef = "demo2EntityManagerFactory", //设置实体关联管理工厂
        transactionManagerRef = "demo2TransactionManager" //设置事务管理
)
public class Demo2Config {

    @Autowired
    private Environment environment;//可以用它来引入系统环境

    /**
     * 统一配置多数据源之后，自动注入数据源
     */
    @Autowired
    @Qualifier("demo2DataSource")
    private DataSource demo2DataSource;

    /**
     * 自动注入jpa配置
     */
    @Resource
    private JpaProperties jpaProperties;


    /**
     * 将数据源、连接池、以及其他配置策略进行封装返回给事务管理器
     * @param builder
     * @return
     */
    @Bean(name = "demo2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryDemo2(EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(demo2DataSource)
                .properties(jpaProperties.getProperties())
                .packages("com.mengfei.learn.pojo.demo2") //设置实体类所在位置：类或包
                .persistenceUnit("demo2PersistenceUnit") //持久化单元
                .build();
    }

    /**
     * 配置事务管理器
     * @param builder
     * @return
     */
    @Bean(name = "demo2TransactionManager")
    public PlatformTransactionManager transactionManagerDemo2(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactoryDemo2(builder).getObject());
    }

    /**
     * 显式配置数据源
     */
    /*@Bean
    public DataSource demo2DataSource() {
        DataSourceProperties demo2DataSourceProperties = demo2DataSourceProperties();
        //DataSourceBuilder从前缀对象中读取配置属性的值
        return DataSourceBuilder.create()
                .driverClassName(demo2DataSourceProperties.getDriverClassName())
                .url(demo2DataSourceProperties.getUrl())
                .username(demo2DataSourceProperties.getUsername())
                .password(demo2DataSourceProperties.getPassword())
                .build();
    }
    @Bean
    //定义前缀属性对象
    @ConfigurationProperties(prefix="datasource.demo2")
    public DataSourceProperties demo2DataSourceProperties() {
        return new DataSourceProperties();
    }*/

    /**
     * 设置DataSource初始化
     * @return
     */
    /*@Bean
    public DataSourceInitializer demo2DataSourceInitializer() {
        DataSourceInitializer dsInitializer = new DataSourceInitializer();
        dsInitializer.setDataSource(demo2DataSource());
        ResourceDatabasePopulator dbPopulator = new ResourceDatabasePopulator();
        dbPopulator.addScript(new ClassPathResource("security-data.sql"));//如果初始化则读取这个sql文件
        dsInitializer.setDatabasePopulator(dbPopulator);
        dsInitializer.setEnabled(environment.getProperty("datasource.demo2.initialize",
                Boolean.class, false) );
        return dsInitializer;
    }*/


}
