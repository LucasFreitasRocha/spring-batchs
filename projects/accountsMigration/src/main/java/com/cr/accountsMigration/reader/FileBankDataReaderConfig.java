package com.cr.accountsMigration.reader;


import com.cr.accountsMigration.model.BankData;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileBankDataReaderConfig {

    @Bean
    public ItemReader<BankData> fileBankDataReader(){
        return  null;
    }
}
