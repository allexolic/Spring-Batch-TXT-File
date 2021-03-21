package com.acurvelo.importarbancos.writer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acurvelo.importarbancos.model.Banco;

@Configuration
public class JdbcArquivoBancosWriter {

	@Bean
	public JdbcBatchItemWriter jdbcArquivoWriter(
			@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Banco>()
				.dataSource(dataSource)
				.sql("INSERT INTO Banco (codigo, nome, web_site) "
						+ " VALUES(?,?,?)")
				.itemPreparedStatementSetter(itemPreparedStatementSetter())
				.build();
	}

	private ItemPreparedStatementSetter<Banco> itemPreparedStatementSetter() {
		return new ItemPreparedStatementSetter<Banco>() {

			@Override
			public void setValues(Banco item, PreparedStatement ps) throws SQLException {
				ps.setString(1, item.getCodigo());
				ps.setString(2, item.getNome());
				ps.setString(3, item.getWebSite());
			}
			
		};
	}
}
