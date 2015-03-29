package ch.ethz.globis.isk.persistence.mongo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.Conference;
import ch.ethz.globis.isk.domain.ConferenceEdition;
import ch.ethz.globis.isk.domain.mongo.DomainConferenceEdition;
import ch.ethz.globis.isk.persistence.ConferenceDao;
import ch.ethz.globis.isk.persistence.ConferenceEditionDao;

@Repository
public class MongoConferenceEditionDao extends MongoDao<String, ConferenceEdition> implements ConferenceEditionDao {

	@Autowired
	ConferenceDao conferenceDao;
	
    @Override
    protected Class<DomainConferenceEdition> getStoredClass() {
        return DomainConferenceEdition.class;
    }

    @Override
    public ConferenceEdition createEntity() {
        return new DomainConferenceEdition();
    }

    @Override
    public List<ConferenceEdition> findByConferenceOrderedByYear(String conferenceId) {
    	Conference conference = conferenceDao.findOne(conferenceId);
        List<ConferenceEdition> editions = new ArrayList<ConferenceEdition>(conference.getEditions());
        Collections.sort(editions, new SortByYearAscendingComparator());
    	return editions;
    }
    
    private static class SortByYearAscendingComparator implements Comparator<ConferenceEdition>{
    	@Override
		public int compare(ConferenceEdition o1, ConferenceEdition o2) {
    		return o1.getYear().compareTo(o2.getYear());
		}
    }
}