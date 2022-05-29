package com.cr.creditcardbill.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class CreditCardBillJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;


    @Bean
    public Job creditCardBillJobConfig(){
        return jobBuilderFactory
                .get("creditCardBillJobConfig")
                
    }
}
