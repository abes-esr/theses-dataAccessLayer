package fr.abes.theses.thesesAccessLayer.configuration;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(
        basePackages = "fr.abes.theses.thesesAccessLayer.dao.portail",
        entityManagerFactoryRef = "portailEntityManager",
        transactionManagerRef = "portailTransactionManager"
)
@NoArgsConstructor
public class PortailConfig extends AbstractConfig {
    @Value("${spring.datasource.portail.url}")
    private String url;
    @Value("${portail.datasource.username}")
    private String username;
    @Value("${portail.datasource.password}")
    private String password;

    @Bean
    public LocalContainerEntityManagerFactoryBean portailEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(portailDataSource());
        em.setPackagesToScan(
                new String[] { "fr.abes.theses.thesesAccessLayer.model.entities.portail" });
        configHibernate(em, "PORTAIL");
        return em;
    }

    @Bean
    public DataSource portailDataSource() {
        return getDataSource(url, username, password);
    }

    @Bean
    public PlatformTransactionManager portailTransactionManager() {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                portailEntityManager().getObject());
        return transactionManager;
    }
}
