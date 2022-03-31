package loja.dao;

import javax.persistence.EntityManager;

import loja.modelo.Categoria;
import loja.modelo.Produto;

public class CategoriaDAO {
	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	public void remover(Categoria categoria) {
		categoria =this.em.merge(categoria);
		this.em.remove(categoria);
	}
}
