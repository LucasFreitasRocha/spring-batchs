package com.cr.accountsMigration.writer;

import com.cr.accountsMigration.model.Person;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class filePersonWriterConfig {

    @Bean
    public ItemWriter<Person> filePersonWriter(){
        return null;
    }
}
