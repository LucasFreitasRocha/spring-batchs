package com.springbatch.processadorclassifier.processor;

import com.springbatch.processadorclassifier.dominio.Transacao;
import org.springframework.batch.item.ItemProcessor;

public class TransacaoProcessor implements ItemProcessor<Transacao, Transacao> {
    @Override
    public Transacao process(Transacao item) throws Exception {

        System.out.println(String.format("\n aplicando regras de negocio da transacao docliente %s", item.getId()));
        return item ;
    }
}
