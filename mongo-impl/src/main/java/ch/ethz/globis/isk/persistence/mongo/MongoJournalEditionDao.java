package ch.ethz.globis.isk.persistence.mongo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.Journal;
import ch.ethz.globis.isk.domain.JournalEdition;
import ch.ethz.globis.isk.domain.mongo.DomainJournalEdition;
import ch.ethz.globis.isk.persistence.JournalDao;
import ch.ethz.globis.isk.persistence.JournalEditionDao;

@Repository
public class MongoJournalEditionDao extends MongoDao<String, JournalEdition> implements JournalEditionDao {
	
	@Autowired
	JournalDao journalDao;

    @Override
    protected Class<DomainJournalEdition> getStoredClass() {
        return DomainJournalEdition.class;
    }

    @Override
    public JournalEdition createEntity() {
        return new DomainJournalEdition();
    }

    @Override
    public List<JournalEdition> findByJournalIdOrdered(String journalId) {
    	Journal journal = journalDao.findOne(journalId);
        List<JournalEdition> editions = new ArrayList<JournalEdition>(journal.getEditions());
        Collections.sort(editions, new SortByYearAscendingComparator());
    	return editions;
    }
    
    private static class SortByYearAscendingComparator implements Comparator<JournalEdition>{
    	@Override
		public int compare(JournalEdition o1, JournalEdition o2) {
    		int compare = o1.getYear().compareTo(o2.getYear());
    		if (compare == 0){
    			compare = o1.getVolume().compareTo(o2.getVolume());
    			if (compare == 0){
    				compare = o1.getNumber().compareTo(o2.getNumber());
    			}
    		}
			return compare;
		}
    }
}
