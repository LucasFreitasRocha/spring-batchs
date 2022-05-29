package com.cr.accountsMigration.writer;


import com.cr.accountsMigration.model.Person;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class FilePersonInvalidWriterConfig {

    @Bean
    public FlatFileItemWriter<Person> filePersonInvalidWriter(){
        return new FlatFileItemWriterBuilder<Person>()
                .name("filePersonInvalidWriter")
                .resource(new FileSystemResource("files/pessoas_invalidas.csv"))
                .delimited()
                .names("id")
                .build();
    }

}
