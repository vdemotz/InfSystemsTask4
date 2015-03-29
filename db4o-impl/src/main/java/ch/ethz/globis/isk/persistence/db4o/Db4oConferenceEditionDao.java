package ch.ethz.globis.isk.persistence.db4o;

import java.util.List;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.ConferenceEdition;
import ch.ethz.globis.isk.domain.db4o.DomainConferenceEdition;
import ch.ethz.globis.isk.persistence.ConferenceEditionDao;

import com.db4o.query.Query;

@Repository
public class Db4oConferenceEditionDao extends Db4oDao<String, ConferenceEdition> implements ConferenceEditionDao {

    @Override
    protected Class<ConferenceEdition> getStoredClass() {
        return ConferenceEdition.class;
    }

    @Override
    public ConferenceEdition createEntity() {
        return new DomainConferenceEdition();
    }

    @Override
    public List<ConferenceEdition> findByConferenceOrderedByYear(String conferenceId) {
    	Query query = oc.query();
    	query.constrain(this.getStoredClass());
    	query.descend(PersistenceAttributes.CONFERENCE.toString()).descend(PersistenceAttributes.ID.toString()).constrain(conferenceId);
    	query.descend(PersistenceAttributes.YEAR.toString()).orderAscending();
    	List<ConferenceEdition> result = query.execute();
    	return result;
    }

}
