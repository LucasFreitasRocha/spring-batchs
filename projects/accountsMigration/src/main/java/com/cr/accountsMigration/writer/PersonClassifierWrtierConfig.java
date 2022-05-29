package com.cr.accountsMigration.writer;

import com.cr.accountsMigration.model.Person;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonClassifierWrtierConfig {
    @Bean
    public ClassifierCompositeItemWriter<Person> personClassifierWriter(
            JdbcBatchItemWriter<Person> filePersonWriter,
            FlatFileItemWriter<Person> filePersonInvalidWriter) {
        return new ClassifierCompositeItemWriterBuilder<Person>()
                .classifier(classifier(filePersonWriter, filePersonInvalidWriter))
                .build();
    }

    private Classifier<Person, ItemWriter<? super Person>> classifier
            (JdbcBatchItemWriter<Person> filePersonWriter,
             FlatFileItemWriter<Person> filePersonInvalidWriter) {
        return new Classifier<Person, ItemWriter<? super Person>>() {

            @Override
            public ItemWriter<? super Person> classify(Person Person) {
                if (Person.isValida())
                    return filePersonWriter;
                else
                    return filePersonInvalidWriter;
            }

        };
    }

}

