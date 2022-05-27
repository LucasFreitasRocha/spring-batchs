package com.cr.accountsMigration.step;


import com.cr.accountsMigration.model.BankData;
import com.cr.accountsMigration.model.Person;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MigrateBankDataStepConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step migrateBankDataStep(
            ItemReader<BankData> fileBankDataReader,
            ItemWriter<BankData> fileBankDatawriter

    ){
        return  stepBuilderFactory
                .get("migrateBankDataStep")
                .<BankData, BankData>chunk(1000)
                .reader(fileBankDataReader)
                .writer(fileBankDatawriter)
                .build();
    }

}
