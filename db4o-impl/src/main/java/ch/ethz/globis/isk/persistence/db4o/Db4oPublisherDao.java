package ch.ethz.globis.isk.persistence.db4o;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.Publisher;
import ch.ethz.globis.isk.domain.db4o.DomainPublisher;
import ch.ethz.globis.isk.persistence.PublisherDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;



@Repository
public class Db4oPublisherDao extends Db4oDao<String, Publisher> implements PublisherDao {

    @Override
    protected Class<Publisher> getStoredClass() {
        return Publisher.class;
    }

    @Override
    public Publisher createEntity() {
        return new DomainPublisher();
    }

    @Override
    public Publisher findOneByName(String name) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put(PersistenceAttributes.NAME.toString(), new Filter(Operator.EQUAL, name));
        return findOneByFilter(filterMap);
    }

}
