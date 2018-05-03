package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Caixa;

public class CaixaDaoTest {
	
	@Test
	@Ignore
	public void salvar() throws ParseException {
		Caixa caixa = new Caixa();
		
		caixa.setDataAbertura(new SimpleDateFormat("dd/MM/yyyy").parse("03/05/2018"));
		caixa.setValor(new BigDecimal("100.00"));
		
		CaixaDao caixaDao = new CaixaDao();
		
		caixaDao.merge(caixa);
	}
	
	@Test
	public void buscar() throws ParseException {
		
		CaixaDao caixaDao = new CaixaDao();
		Caixa caixa = caixaDao.buscar(new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2018"));
		System.out.println(caixa);
		Assert.assertNull(caixa);
		
	}
}
