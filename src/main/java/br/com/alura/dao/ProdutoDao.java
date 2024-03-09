package br.com.alura.dao;

import br.com.alura.modelo.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoDao {

    private final EntityManager entityManager;

    public ProdutoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto) {
        this.entityManager.persist(produto);
    }
}
