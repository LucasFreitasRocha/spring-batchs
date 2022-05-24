package com.cr.accountsMigration.step;

import com.cr.accountsMigration.model.Person;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MigratePersonStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step migratePersonStep(
          ItemReader<Person>  filePersonReader,
          ItemWriter<Person> filePersonWriter
    ) {
        return  stepBuilderFactory
                .get("migratePersonStep")
                .<Person, Person>chunk(1)
                .reader(filePersonReader)
                .writer(filePersonWriter)
                .build();
    }
}
