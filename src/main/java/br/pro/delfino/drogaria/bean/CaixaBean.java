package br.pro.delfino.drogaria.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import br.pro.delfino.drogaria.dao.CaixaDao;
import br.pro.delfino.drogaria.dao.FuncionarioDao;
import br.pro.delfino.drogaria.domain.Caixa;
import br.pro.delfino.drogaria.domain.Funcionario;

@ManagedBean
@ViewScoped
public class CaixaBean {
	private Caixa caixa;
	private List<Funcionario> funcionarios;
	private ScheduleModel caixas;

	
	
	
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public ScheduleModel getCaixas() {
		return caixas;
	}

	public void setCaixas(ScheduleModel caixas) {
		this.caixas = caixas;
	}
	
	@PostConstruct
	public void listar() {
		caixas = new DefaultScheduleModel(); 
	}
	
	public void novo(SelectEvent evento) {
		caixa = new Caixa();
		caixa.setDataAbertura((Date)evento.getObject());
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarios = funcionarioDao.listar();
	}
	
	public void salvar() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(caixa.getDataAbertura());
		calendar.add(Calendar.DATE, 1);
		caixa.setDataAbertura(calendar.getTime());
		
		CaixaDao caixaDao = new CaixaDao();
		caixaDao.salvar(caixa);
		Messages.addGlobalInfo("Caixa aberto com sucesso");
		
	}
}
