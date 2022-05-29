package com.cr.accountsMigration.step;

import com.cr.accountsMigration.model.Person;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
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
          ClassifierCompositeItemWriter<Person> personClassifierWriter,
          FlatFileItemWriter<Person> filePersonInvalidWriter
    ) {
        return  stepBuilderFactory
                .get("migratePersonStep")
                .<Person, Person>chunk(1000)
                .reader(filePersonReader)
                .writer(personClassifierWriter)
                .stream(filePersonInvalidWriter)
                .build();
    }
}
