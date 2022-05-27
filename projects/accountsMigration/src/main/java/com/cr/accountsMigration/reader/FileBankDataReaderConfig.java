package com.cr.accountsMigration.reader;


import com.cr.accountsMigration.model.BankData;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.validation.BindException;

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
                .fieldSetMapper(fieldSetMapper())
                .build();
    }

    private FieldSetMapper<BankData> fieldSetMapper() {
        return new FieldSetMapper<BankData>() {
            @Override
            public BankData mapFieldSet(FieldSet fieldSet) throws BindException {
                BankData bankData = new BankData();
                bankData.setId(fieldSet.readInt("id"));
                bankData.setBank(fieldSet.readInt("bank"));
                bankData.setAccount(fieldSet.readInt("account"));
                bankData.setAgency(fieldSet.readInt("agency"));
                bankData.setPersonId(fieldSet.readInt("person_id"));
                return bankData;
            }
        };
    }


}
