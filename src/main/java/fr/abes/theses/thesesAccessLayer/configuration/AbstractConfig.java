package fr.abes.theses.thesesAccessLayer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;

public abstract class AbstractConfig {
    @Value("${spring.datasource.driver-class-name}")
    protected String driver;
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.jpa.show-sql}")
    protected String showsql;
    @Value("${spring.jpa.properties.hibernate.dialect}")
    protected String dialect;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    protected String ddlAuto;
    @Value("${spring.jpa.database-platform}")
    protected String platform;

    protected void configHibernate(LocalContainerEntityManagerFactoryBean em) {
        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("spring.jpa.database-platform", platform);
        properties.put("hibernate.show_sql", showsql);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.dialect", dialect);
        properties.put("logging.level.org.hibernate", "DEBUG");
        properties.put("hibernate.type", "trace");
        em.setJpaPropertyMap(properties);
    }

    protected DataSource getDataSource(String username, String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}
