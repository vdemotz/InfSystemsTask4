package ch.ethz.globis.isk.persistence.db4o;

import java.util.List;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.JournalEdition;
import ch.ethz.globis.isk.domain.db4o.DomainJournalEdition;
import ch.ethz.globis.isk.persistence.JournalEditionDao;

import com.db4o.query.Query;

@Repository
public class Db4oJournalEditionDao extends Db4oDao<String, JournalEdition> implements JournalEditionDao {

    @Override
    protected Class<JournalEdition> getStoredClass() {
        return JournalEdition.class;
    }

    @Override
    public JournalEdition createEntity() {
        return new DomainJournalEdition();
    }

    @Override
    public List<JournalEdition> findByJournalIdOrdered(String journalId) {
    	Query query = oc.query();
    	query.constrain(this.getStoredClass());
    	query.descend(PersistenceAttributes.JOURNAL.toString()).descend(PersistenceAttributes.ID.toString()).constrain(journalId);
    	query.descend(PersistenceAttributes.YEAR.toString()).orderAscending();
    	query.descend(PersistenceAttributes.VOLUME.toString()).orderAscending();
    	query.descend(PersistenceAttributes.NUMBER.toString()).orderAscending();
    	List<JournalEdition> result = query.execute();
    	return result;
    }

}
