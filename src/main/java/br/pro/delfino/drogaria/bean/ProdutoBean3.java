package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.FabricanteDao;
import br.pro.delfino.drogaria.dao.ProdutoDao;
import br.pro.delfino.drogaria.domain.Fabricante;
import br.pro.delfino.drogaria.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean3 implements Serializable {
	
	private Produto produto;
	private List<Fabricante> fabricantes;
	private List<Produto> produtos;
	
	private FabricanteDao fabricanteDao;
	private ProdutoDao produtoDao;
	
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	@PostConstruct
	public void iniciar() {
		fabricanteDao = new FabricanteDao();
		produtoDao = new ProdutoDao();
		
	}
	
	public void listar() {

		try {

			produtos = produtoDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os Produtos");
			erro.printStackTrace();
		}

	}
	

}
