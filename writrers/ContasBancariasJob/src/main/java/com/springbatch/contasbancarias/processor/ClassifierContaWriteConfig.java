package com.springbatch.contasbancarias.processor;

import com.springbatch.contasbancarias.dominio.Conta;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class ClassifierContaWriteConfig {

    @Bean
    public ClassifierCompositeItemWriter<Conta> classifierContaWriter(
            @Qualifier("clientesInvalidosWriter")FlatFileItemWriter<Conta> clienteInvalidoWriter,
            CompositeItemWriter<Conta> compositeItemWriter
            ){
        return new ClassifierCompositeItemWriterBuilder<Conta>()
                .classifier(classifier(clienteInvalidoWriter, compositeItemWriter))
                .build();
    }

    private Classifier<Conta, ItemWriter<? super Conta>> classifier
            (FlatFileItemWriter<Conta> clienteInvalidoWriter,
             CompositeItemWriter<Conta> compositeItemWriter) {
        return  new Classifier<Conta, ItemWriter<? super Conta>>() {
            @Override
            public ItemWriter<? super Conta> classify(Conta conta) {
              return  (conta.getTipo() != null) ? compositeItemWriter : clienteInvalidoWriter;
            }
        };

    }
}
