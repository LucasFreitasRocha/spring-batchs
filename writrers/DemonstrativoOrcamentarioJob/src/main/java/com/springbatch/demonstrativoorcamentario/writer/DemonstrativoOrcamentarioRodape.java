package com.springbatch.demonstrativoorcamentario.writer;

import com.springbatch.demonstrativoorcamentario.dominio.GrupoLancamento;
import org.springframework.batch.core.annotation.AfterChunk;
import org.springframework.batch.core.annotation.BeforeWrite;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.text.NumberFormat;
import java.util.List;

@Component
public class DemonstrativoOrcamentarioRodape implements FlatFileFooterCallback {

    private double totalGeral;

    @Override
    public void writeFooter(Writer writer) throws IOException {
        writer.append("\n");
        writer.append(String.format("\t\t\t\t\t\t\t  Total: %s\n",
                NumberFormat.getCurrencyInstance().format(totalGeral)));
        writer.append(String.format("\t\t\t\t\t\t\t  Código de Autenticação: %s", "fkyew6868fewjfhjjewf\n"));
    }

    @BeforeWrite
    public  void beforeWrite(List<GrupoLancamento> gruposLancamento){
        gruposLancamento.forEach(gl -> totalGeral += gl.getTotal());
    }

    @AfterChunk
    public void AfterChunk(ChunkContext chunkContext){
        totalGeral = 0.0;
    }
}
