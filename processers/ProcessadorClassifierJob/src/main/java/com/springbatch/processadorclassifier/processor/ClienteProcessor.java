package com.springbatch.processadorclassifier.processor;

import com.springbatch.processadorclassifier.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;

public class ClienteProcessor implements ItemProcessor<Cliente, Cliente> {

    @Override
    public Cliente process(Cliente item) throws Exception {

        System.out.println(String.format("\n aplicando regras de negocio do cliente %s", item.getEmail()));
        return item ;
    }
}
