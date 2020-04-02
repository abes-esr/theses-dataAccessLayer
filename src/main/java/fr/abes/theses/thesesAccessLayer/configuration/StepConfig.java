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
        basePackages = "fr.abes.theses.thesesAccessLayer.dao.step",
        entityManagerFactoryRef = "stepEntityManager",
        transactionManagerRef = "stepTransactionManager"
)
@NoArgsConstructor
public class StepConfig extends AbstractConfig {
    @Value("${step.datasource.username}")
    private String username;
    @Value("${step.datasource.password}")
    private String password;

    @Bean
    public LocalContainerEntityManagerFactoryBean stepEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(stepDataSource());
        em.setPackagesToScan(
                new String[]{"fr.abes.theses.thesesAccessLayer.model.entities.step"});
        configHibernate(em);
        return em;
    }

    @Bean
    public DataSource stepDataSource() {
        return getDataSource(username, password);
    }

    @Bean
    public PlatformTransactionManager stepTransactionManager() {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                stepEntityManager().getObject());
        return transactionManager;
    }
}
