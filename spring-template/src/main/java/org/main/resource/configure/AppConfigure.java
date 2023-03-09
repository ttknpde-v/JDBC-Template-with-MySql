package org.main.resource.configure;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages="org.main.resource")
/* both Annotation คู่กัน
*  basePackages is Attribute of Annotation */
public class AppConfigure {
    /* retrieve info from properties file */
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3307/mystudent";
    private final String USER = "thitikorn_db";
    private final String PASSWORD = "Architecture.890.098";
    private DriverManagerDataSource dataSource;

    @Bean
    /* @Bean -> when I create / load spring bean this method works now
    *  method for Connect Database */
    public DriverManagerDataSource dataSource () {

        dataSource = new DriverManagerDataSource(URL,USER,PASSWORD);
        dataSource.setDriverClassName(DRIVER);
        return dataSource ;

    }

}
