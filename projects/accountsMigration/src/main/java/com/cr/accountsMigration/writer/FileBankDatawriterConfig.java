package com.cr.accountsMigration.writer;


import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.cr.accountsMigration.model.BankData;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class FileBankDatawriterConfig {

    @Bean
    public JdbcBatchItemWriter<BankData> fileBankDatawriter(
            @Qualifier("appDataSource") DataSource dataSource
    ){
        return new JdbcBatchItemWriterBuilder<BankData>()
                .dataSource(dataSource)
                .sql("INSERT INTO bank_data(id, person_id, agency, account, bank)" +
                        " VALUES (:id, :personId, :agency, :account, :bank)")
                .beanMapped()
                .itemPreparedStatementSetter(itemPreparedStatementSetter())
                .build();

    }

    private ItemPreparedStatementSetter<BankData> itemPreparedStatementSetter() {
        return new ItemPreparedStatementSetter<BankData>() {
            @Override
            public void setValues(BankData bankData, PreparedStatement ps) throws SQLException {
                ps.setInt(1, bankData.getId());
                ps.setInt(2, bankData.getPersonId());
                ps.setInt(3, bankData.getAgency());
                ps.setInt(4, bankData.getAccount());
                ps.setInt(5, bankData.getBank());

            }
        };
    }
}
