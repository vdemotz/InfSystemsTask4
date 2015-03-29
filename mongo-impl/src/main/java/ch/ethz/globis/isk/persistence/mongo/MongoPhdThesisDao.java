package ch.ethz.globis.isk.persistence.mongo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.PhdThesis;
import ch.ethz.globis.isk.domain.mongo.DomainPhdThesis;
import ch.ethz.globis.isk.persistence.PhdThesisDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class MongoPhdThesisDao extends MongoDao<String, PhdThesis> implements PhdThesisDao {


    @Override
    protected Class<DomainPhdThesis> getStoredClass() {
        return DomainPhdThesis.class;
    }

    @Override
    public PhdThesis findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("title", new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }

    @Override
    public PhdThesis createEntity() {
        return new DomainPhdThesis();
    }
}