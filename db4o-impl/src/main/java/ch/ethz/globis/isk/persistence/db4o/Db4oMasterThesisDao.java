package ch.ethz.globis.isk.persistence.db4o;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.MasterThesis;
import ch.ethz.globis.isk.domain.db4o.DomainMasterThesis;
import ch.ethz.globis.isk.persistence.MasterThesisDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class Db4oMasterThesisDao extends Db4oDao<String, MasterThesis> implements MasterThesisDao {

    @Override
    protected Class<MasterThesis> getStoredClass() {
        return MasterThesis.class;
    }

    @Override
    public MasterThesis findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put(PersistenceAttributes.TITLE.toString(), new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }

    @Override
    public MasterThesis createEntity() {
        return new DomainMasterThesis();
    }

}
