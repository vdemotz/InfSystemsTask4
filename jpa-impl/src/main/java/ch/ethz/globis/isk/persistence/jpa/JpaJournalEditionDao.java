package ch.ethz.globis.isk.persistence.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.JournalEdition;
import ch.ethz.globis.isk.domain.jpa.JpaJournalEdition;
import ch.ethz.globis.isk.persistence.JournalEditionDao;

@Repository
public class JpaJournalEditionDao extends JpaDao<String, JournalEdition> implements JournalEditionDao {

    @Override
    protected Class<JpaJournalEdition> getStoredClass() {
        return JpaJournalEdition.class;
    }

    @Override
    public JournalEdition createEntity() {
        return new JpaJournalEdition();
    }

    @Override
    public List<JournalEdition> findByJournalIdOrdered(String journalId) {
        String findAuthorsQuery = "Select je from JournalEdition je JOIN je.journal j " +
                "WHERE j.id = :journalId ORDER BY je.year, je.volume, je.number ASC";
        Query query = em.createQuery(findAuthorsQuery);
        query.setParameter("journalId", journalId);
        return query.getResultList();
    }
}
