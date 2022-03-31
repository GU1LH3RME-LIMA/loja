package loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import loja.modelo.Produto;

public class ProdutoDAO {
	private EntityManager em;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
		this.em.getTransaction().commit();
		this.em.close();
	}
	public void ataulizar(Produto produto) {
		this.em.merge(produto);
	}
	public void remover(Produto produto) {
		this.em.remove(produto);
	}
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	public List<Produto> buscarTodos(){
		return em.createQuery("SELECT p FROM Produto p",Produto.class).getResultList();
	}
	public List<Produto> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                        .getResultList();
}
}
