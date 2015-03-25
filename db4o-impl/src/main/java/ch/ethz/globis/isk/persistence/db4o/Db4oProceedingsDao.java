package ch.ethz.globis.isk.persistence.db4o;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.db4o.Db4oProceedings;
import ch.ethz.globis.isk.domain.Proceedings;
import ch.ethz.globis.isk.persistence.ProceedingsDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class Db4oProceedingsDao extends Db4oDao<String, Proceedings> implements ProceedingsDao {

    @Override
    protected Class<Proceedings> getStoredClass() {
        return Proceedings.class;
    }

    @Override
    public Proceedings createEntity() {
        return new Db4oProceedings();
    }

    @Override
    public Proceedings findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put(PersistenceAttributes.TITLE.toString(), new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }

}
