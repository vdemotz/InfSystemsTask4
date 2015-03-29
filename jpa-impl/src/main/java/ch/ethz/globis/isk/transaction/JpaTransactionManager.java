package ch.ethz.globis.isk.transaction;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JpaTransactionManager extends CacheAwareTransactionManager {

    @Autowired
    @Qualifier("entityManager")
    private EntityManager em;

    @Override
    public void commit() {
        em.getTransaction().commit();
    }

    @Override
    public void rollback() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void begin() {
        em.getTransaction().begin();
    }
}