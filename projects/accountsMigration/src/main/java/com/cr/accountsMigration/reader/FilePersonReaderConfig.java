package com.cr.accountsMigration.reader;

import com.cr.accountsMigration.model.Person;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilePersonReaderConfig {


    @Bean
    public ItemReader<Person> filePersonReader(){
        return null;
    }
}
