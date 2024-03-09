package br.com.alura.testes;

import br.com.alura.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager = factory.createEntityManager();

        Produto celular = new Produto();
        celular.setNome("Redmi note 9 PRO");
        celular.setDescricao("Com memória de 258GB e RAM de 6GB");
        celular.setPreco(new BigDecimal("2000.00"));

        entityManager.getTransaction().begin();
        entityManager.persist(celular);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
