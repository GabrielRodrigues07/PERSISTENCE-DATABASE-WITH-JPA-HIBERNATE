package br.com.alura.testes;

import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Produto;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

import static br.com.alura.util.JPAUtil.getEntityManager;

public class CadastroDeProduto {

    public static void main(String[] args) {
        EntityManager entityManager = getEntityManager();

        Produto celular = new Produto();
        celular.setNome("Redmi note 9 PRO");
        celular.setDescricao("Com memória de 258GB e RAM de 6GB");
        celular.setPreco(new BigDecimal("2000.00"));

        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        entityManager.getTransaction().begin();
        produtoDao.cadastrar(celular);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
