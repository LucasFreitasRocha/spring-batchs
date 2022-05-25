package com.cr.accountsMigration.reader;

import com.cr.accountsMigration.model.Person;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.validation.BindException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class FilePersonReaderConfig {


    @Bean
    public FlatFileItemReader<Person> filePersonReader(){
        return new FlatFileItemReaderBuilder<Person>()
                .name("filePersonReader")
                .resource(new FileSystemResource("files/pessoas.csv"))
                .delimited()
                .names("name", "email", "bday", "age", "id")
                .addComment("--")
                .fieldSetMapper(fieldSetMapper())
                // serve para quando não tipo complexos.targetType(Person.class)
                .build();

    }

    private FieldSetMapper<Person> fieldSetMapper() {
        return new FieldSetMapper<Person>() {
            @Override
            public Person mapFieldSet(FieldSet fieldSet) throws BindException {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                Person person = new Person();
                person.setName(fieldSet.readRawString("name"));
                person.setEmail(fieldSet.readRawString("email"));
                person.setBday(LocalDateTime.parse(fieldSet.readRawString("bday"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                person.setAge(fieldSet.readInt("age"));
                person.setId(fieldSet.readInt("id"));
                return  person;
            }
        };
    }
}
