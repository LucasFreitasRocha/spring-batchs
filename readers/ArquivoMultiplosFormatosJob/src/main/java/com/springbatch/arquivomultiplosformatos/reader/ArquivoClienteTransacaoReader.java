package com.springbatch.arquivomultiplosformatos.reader;

import com.springbatch.arquivomultiplosformatos.dominio.Cliente;
import com.springbatch.arquivomultiplosformatos.dominio.Transacao;
import org.springframework.batch.item.*;

import java.util.Objects;

public class ArquivoClienteTransacaoReader implements ItemStreamReader<Cliente> {
    private Object objectAtual;
    private ItemStreamReader<Object> delegate;

    public ArquivoClienteTransacaoReader(ItemStreamReader<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Cliente read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(Objects.isNull(objectAtual)){
            objectAtual = delegate.read();
        }

        Cliente cliente = (Cliente) objectAtual;
        objectAtual = null;
        if(!Objects.isNull(cliente)){
            while (peek() instanceof Transacao){
                cliente.getTransacoes().add((Transacao) objectAtual);
            }
        }
        return  cliente;
    }

    private Object peek() throws Exception {
        objectAtual = delegate.read();
        return objectAtual;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }
}
