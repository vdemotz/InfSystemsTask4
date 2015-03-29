package ch.ethz.globis.isk.persistence.db4o;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.PhdThesis;
import ch.ethz.globis.isk.domain.db4o.DomainPhdThesis;
import ch.ethz.globis.isk.persistence.PhdThesisDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class Db4oPhdThesisDao extends Db4oDao<String, PhdThesis> implements PhdThesisDao  {

    @Override
    protected Class<PhdThesis> getStoredClass() {
        return PhdThesis.class;
    }

    @Override
    public PhdThesis findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put(PersistenceAttributes.TITLE.toString(), new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }

    @Override
    public PhdThesis createEntity() {
        return new DomainPhdThesis();
    }

}
