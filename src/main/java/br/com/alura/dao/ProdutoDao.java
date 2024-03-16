package br.com.alura.dao;

import br.com.alura.modelo.Produto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProdutoDao {

    private final EntityManager entityManager;

    public ProdutoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto) {
        this.entityManager.persist(produto);
    }

    public Produto buscarPorId(Long id) {
        return entityManager.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
        return entityManager.createQuery("SELECT p FROM Produto p WHERE p.nome = :nome", Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome) {
        return entityManager.createQuery("SELECT p FROM Produto p WHERE p.categoria.nome = :nome", Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
