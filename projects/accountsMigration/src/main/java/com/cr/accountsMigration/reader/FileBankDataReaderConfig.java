package com.cr.accountsMigration.reader;


import com.cr.accountsMigration.model.BankData;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class FileBankDataReaderConfig {

    @Bean
    public FlatFileItemReader<BankData> fileBankDataReader(){
        return new FlatFileItemReaderBuilder<BankData>()
                .name("fileBankDataReader")
                .resource(new FileSystemResource("files/dados_bancarios.csv"))
                .delimited()
                .names("person_id", "agency", "account", "bank", "id")
                .addComment("--")
                .targetType(BankData.class)
                .build();
    }
}
