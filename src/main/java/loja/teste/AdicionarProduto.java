package loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import loja.dao.CategoriaDAO;
import loja.dao.ProdutoDAO;
import loja.modelo.Categoria;
import loja.modelo.Produto;
import loja.util.JPAUtil;

public class AdicionarProduto {
	public static void main(String[] args) {
		Add();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		
		Produto p = dao.buscarPorId(1l);
		System.out.println(p.getPreco());
		List<Produto> todos = dao.buscarTodos();
		todos.forEach(p2-> System.out.println(p2.getNome()));
	}
	public static void Add() {
		Produto pce = new Produto();
		pce.setNome("PC Gamer");
		pce.setDescricao("4G RAM, 1TB SSD e GTX 335");
		pce.setPreco(new BigDecimal("1200"));
		
		Categoria info = new Categoria();
		info.setNome("Informatica");
		pce.setCategoria(info);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		CategoriaDAO cdao = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		cdao.cadastrar(info);
		dao.cadastrar(pce);
		
	}
	
}
