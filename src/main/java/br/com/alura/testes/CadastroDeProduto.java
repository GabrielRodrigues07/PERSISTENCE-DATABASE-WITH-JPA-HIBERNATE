package br.com.alura.testes;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

import static br.com.alura.util.JPAUtil.getEntityManager;

public class CadastroDeProduto {

    public static void main(String[] args) {
        EntityManager entityManager = getEntityManager();

        Categoria categoria = new Categoria("CELULARES");
        Produto celular = new Produto("Redmi note 9 PRO", "Com memória de 258GB e RAM de 6GB", new BigDecimal("2000.00"), categoria);

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(categoria);
        produtoDao.cadastrar(celular);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
