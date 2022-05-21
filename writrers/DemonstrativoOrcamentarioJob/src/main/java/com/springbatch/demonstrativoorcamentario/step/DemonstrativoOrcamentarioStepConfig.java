package com.springbatch.demonstrativoorcamentario.step;

import com.springbatch.demonstrativoorcamentario.writer.DemonstrativoOrcamentarioRodape;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.demonstrativoorcamentario.dominio.GrupoLancamento;
import com.springbatch.demonstrativoorcamentario.reader.GrupoLancamentoReader;
import org.springframework.core.io.Resource;

@Configuration
public class DemonstrativoOrcamentarioStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Value("${multiResourceItemWriter}")
	private Boolean multiResourceItemWriterBoolean;

	@Bean
	public Step demonstrativoOrcamentarioStep(
			// Esse aqui lê dos arquivos
			//MultiResourceItemReader<GrupoLancamento> demonstrativoOrcamentarioReader,
			// Esse aqui lê do banco de dados
			GrupoLancamentoReader demonstrativoOrcamentarioReader,
			ItemWriter<GrupoLancamento> demonstrativoOrcamentarioWriter,
			MultiResourceItemWriter<GrupoLancamento> multiDemonstrativoOrcamentarioWriter,
			DemonstrativoOrcamentarioRodape rodapeCallBack) {

		if(multiResourceItemWriterBoolean){
			return stepBuilderFactory
					.get("demonstrativoOrcamentarioStep")
					.<GrupoLancamento,GrupoLancamento>chunk(1)
					.reader(demonstrativoOrcamentarioReader)
					.writer(multiDemonstrativoOrcamentarioWriter)
					.listener(rodapeCallBack)
					.build();
		}else {
			return stepBuilderFactory
					.get("demonstrativoOrcamentarioStep")
					.<GrupoLancamento, GrupoLancamento>chunk(100)
					.reader(demonstrativoOrcamentarioReader)
					.writer(demonstrativoOrcamentarioWriter)
					.listener(rodapeCallBack)
					.build();
		}
	}
}
