package com.hospital301.scientificmanagement.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;

@Configuration
public class DruidConfig 
{
	@Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

//    @Value("${spring.datasource.minIdle}")
//    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private String testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private String testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private String testOnReturn;

   @Value("${spring.datasource.filters}")
    private String filters;

/*    @Value("${spring.datasource.logSlowSql}")
    private String logSlowSql;*/

	@Bean
	  public DataSource druidDataSource() throws SQLException {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
//        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(Boolean.valueOf(testWhileIdle));
        datasource.setTestOnBorrow(Boolean.valueOf(testOnBorrow));
        datasource.setTestOnReturn(Boolean.valueOf(testOnReturn));
        datasource.setFilters(filters);
      
        return datasource;
    }
	
	 @Bean
     public WallFilter wallFilter(){
         WallFilter wallFilter = new WallFilter();
         wallFilter.setConfig(wallConfig());
         return wallFilter;
     }

     @Bean
     public WallConfig wallConfig(){
         WallConfig wallConfig = new WallConfig();
         wallConfig.setMultiStatementAllow(true);//允许一次执行多条语句
         wallConfig.setNoneBaseStatementAllow(true);//允许一次执行多条语句
         return wallConfig;
     }
	

}
