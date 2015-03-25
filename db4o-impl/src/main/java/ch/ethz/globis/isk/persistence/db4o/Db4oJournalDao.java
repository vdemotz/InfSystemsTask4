package ch.ethz.globis.isk.persistence.db4o;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.db4o.Db4oJournal;
import ch.ethz.globis.isk.domain.Journal;
import ch.ethz.globis.isk.persistence.JournalDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class Db4oJournalDao extends Db4oDao<String, Journal> implements JournalDao {

    @Override
    protected Class<Journal> getStoredClass() {
        return Journal.class;
    }

    @Override
    public Journal findOneByName(String name) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put(PersistenceAttributes.NAME.toString(), new Filter(Operator.EQUAL, name));
        return findOneByFilter(filterMap);
    }

    @Override
    public Journal createEntity() {
        return new Db4oJournal();
    }

}
