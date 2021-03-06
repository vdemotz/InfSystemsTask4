package ch.ethz.globis.isk.persistence.mongo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ch.ethz.globis.isk.domain.Proceedings;
import ch.ethz.globis.isk.domain.mongo.DomainProceedings;
import ch.ethz.globis.isk.persistence.ProceedingsDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
@Transactional
public class MongoProceedingsDao extends MongoDao<String, Proceedings> implements ProceedingsDao {

    @Override
    protected Class<DomainProceedings> getStoredClass() {
        return DomainProceedings.class;
    }

    @Override
    public Proceedings createEntity() {
        return new DomainProceedings();
    }

    @Override
    public Proceedings findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("title", new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }
}