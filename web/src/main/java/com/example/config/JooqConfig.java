package com.example.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.RenderKeywordCase;
import org.jooq.conf.RenderQuotedNames;
import org.jooq.conf.Settings;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

/**
 * @author gaoyang
 * @email 785175323@qq.com
 */
@Configuration
public class JooqConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().
                build();
    }

    /***
     * 配置事务管理器
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /***
     * 配置数据源代理
     */
    @Bean("demoDataSource")
    public TransactionAwareDataSourceProxy transactionAwareDataSourceProxy(DataSource dataSource) {
        return new TransactionAwareDataSourceProxy(dataSource);
    }

    /**
     * 配置JOOQ数据源连接器
     */
    @Bean("myConnectionProvider")
    public DataSourceConnectionProvider jooqConnectionProvider(DataSource dataSource) {
        return new DataSourceConnectionProvider(dataSource);
    }


    @Bean
    public DefaultConfiguration defaultConfiguration(DataSource dataSource,
                                                     DataSourceConnectionProvider myConnectionProvider) {
        DefaultConfiguration defaultConfiguration = new DefaultConfiguration();
        defaultConfiguration.setDataSource(dataSource);
        defaultConfiguration.set(new Settings().
                withParseDialect(SQLDialect.MYSQL).
                withRenderSchema(false).
                withRenderKeywordCase(RenderKeywordCase.UPPER).
                withRenderQuotedNames(RenderQuotedNames.NEVER));
        defaultConfiguration.setConnectionProvider(myConnectionProvider);
        return defaultConfiguration;
    }

    @Bean
    public DSLContext dslContext(DefaultConfiguration configuration) {
        return new DefaultDSLContext(configuration);
    }
}
