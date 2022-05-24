package com.springbatch.contasbancarias.processor;

import com.springbatch.contasbancarias.dominio.Cliente;
import com.springbatch.contasbancarias.dominio.Conta;
import org.springframework.batch.item.ItemProcessor;

public class ContaInvalidaItemProcessor implements ItemProcessor<Cliente, Conta> {
    @Override
    public Conta process(Cliente item) throws Exception {
        Conta conta = new Conta();
        conta.setClienteId(item.getEmail());
        return  conta;
    }
}
