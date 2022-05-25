package com.cr.accountsMigration.job;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class AccountMigrationJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job AccountMigrationJobConfig(
           @Qualifier("migratePersonStep") Step migratePersonStep,
           @Qualifier("migrateBankDataStep") Step migrateBankDataStep
            ) {
        return jobBuilderFactory
                .get("AccountMigrationJobConfig")
                .start(migratePersonStep)
                .next(migrateBankDataStep)
                // Para não precisar apagar os metadados.
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
