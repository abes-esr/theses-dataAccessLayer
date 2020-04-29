package fr.abes.theses.thesesAccessLayer.configuration;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "fr.abes.theses.thesesAccessLayer.dao.star",
        entityManagerFactoryRef = "starEntityManager",
        transactionManagerRef = "starTransactionManager"
)
@NoArgsConstructor
public class StarConfig extends AbstractConfig{
    @Value("${star.datasource.username}")
    private String username;
    @Value("${star.datasource.password}")
    private String password;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean starEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(starDataSource());
        em.setPackagesToScan(
                new String[] { "fr.abes.theses.thesesAccessLayer.model.entities.star" });
        configHibernate(em);
        return em;
    }

    @Bean
    @Primary
    public DataSource starDataSource() {
        return getDataSource(username, password);
    }

    @Bean
    @Primary
    public PlatformTransactionManager starTransactionManager() {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                starEntityManager().getObject());
        return transactionManager;
    }
}
