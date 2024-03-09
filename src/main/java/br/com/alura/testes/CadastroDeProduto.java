package br.com.alura.testes;

import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Produto;
import br.com.alura.modelo.enums.Categoria;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

import static br.com.alura.util.JPAUtil.getEntityManager;

public class CadastroDeProduto {

    public static void main(String[] args) {
        EntityManager entityManager = getEntityManager();

        Produto celular = new Produto("Redmi note 9 PRO", "Com memória de 258GB e RAM de 6GB", new BigDecimal("2000.00"), Categoria.CELULARES);

        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        entityManager.getTransaction().begin();
        produtoDao.cadastrar(celular);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
