package br.pro.delfino.drogaria.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.pro.delfino.drogaria.dao.ProdutoDao;
import br.pro.delfino.drogaria.domain.Produto;


//http://127.0.0.1:8080/Drogaria/rest/produto
@Path("produto")
public class ProdutoService {
	
	@GET
	public String listar() {
		ProdutoDao produtoDao = new ProdutoDao();
		List<Produto> produtos = produtoDao.listar("descricao");
		
		Gson gson = new Gson();
		String json = gson.toJson(produtos);
		return json;
	}
	
	@POST
	public String salvar(String json) {
		Gson gson = new Gson();
		Produto produto = gson.fromJson(json, Produto.class);
		
	
		ProdutoDao produtoDao = new ProdutoDao();
		produto = produtoDao.merge(produto);
		
		String jsonSaida = gson.toJson(produto);
		
		return jsonSaida;
		
	}
	

}
