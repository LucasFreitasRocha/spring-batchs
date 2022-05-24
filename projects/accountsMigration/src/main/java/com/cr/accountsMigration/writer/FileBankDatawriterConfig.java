package com.cr.accountsMigration.writer;

import com.cr.accountsMigration.model.BankData;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileBankDatawriterConfig {

    @Bean
    public ItemWriter<BankData> fileBankDatawriter(){
        return null;
    }
}
