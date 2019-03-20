package com.mengfei.learn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 一个多数据源事务的配置类
 */

@Configuration
@EnableJpaRepositories(
        //basePackageClasses = 设置Repository所在的类
        basePackages = "com.mengfei.learn.mapper.demo", //设置Repository所在的包
        entityManagerFactoryRef = "demoEntityManagerFactory", //设置实体关联管理工厂
        transactionManagerRef = "demoTransactionManager" //设置事务管理
)
public class DemoConfig {

    @Autowired
    private Environment environment;//可以用它来引入系统环境

    /**
     * 统一配置多数据源之后，自动注入数据源
     */
    @Autowired
    @Qualifier("demoDataSource")
    private DataSource demoDataSource;

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
    @Primary //自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常
    @Bean(name = "demoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryDemo(EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(demoDataSource)
                .properties(jpaProperties.getProperties())
                .packages("com.mengfei.learn.pojo.demo") //设置实体类所在位置：类或包
                .persistenceUnit("demoPersistenceUnit") //持久化单元
                .build();
    }

    /**
     * 配置事务管理器
     * @param builder
     * @return
     */
    @Primary //自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常
    @Bean(name = "demoTransactionManager")
    public PlatformTransactionManager transactionManagerDemo(EntityManagerFactoryBuilder builder){
        //EntityManagerFactory entityManagerFactory = entityManagerFactoryDemo(builder).getObject();
        return new JpaTransactionManager(entityManagerFactoryDemo(builder).getObject());
    }

    /**
     * 显式配置数据源
     */
    /*@Bean
    public DataSource demoDataSource() {
        DataSourceProperties demoDataSourceProperties = demoDataSourceProperties();
        //DataSourceBuilder从前缀对象中读取配置属性的值
        return DataSourceBuilder.create()
                .driverClassName(demoDataSourceProperties.getDriverClassName())
                .url(demoDataSourceProperties.getUrl())
                .username(demoDataSourceProperties.getUsername())
                .password(demoDataSourceProperties.getPassword())
                .build();
    }
    @Bean
    //定义前缀属性对象
    @ConfigurationProperties(prefix="datasource.demo")
    public DataSourceProperties demoDataSourceProperties() {
        return new DataSourceProperties();
    }*/

    /**
     * 设置DataSource初始化
     * @return
     */
    /*@Bean
    public DataSourceInitializer demoDataSourceInitializer() {
        DataSourceInitializer dsInitializer = new DataSourceInitializer();
        dsInitializer.setDataSource(demoDataSource());
        ResourceDatabasePopulator dbPopulator = new ResourceDatabasePopulator();
        dbPopulator.addScript(new ClassPathResource("security-data.sql"));//如果初始化则读取这个sql文件
        dsInitializer.setDatabasePopulator(dbPopulator);
        dsInitializer.setEnabled(environment.getProperty("datasource.demo.initialize",
                Boolean.class, false) );
        return dsInitializer;
    }*/


}
