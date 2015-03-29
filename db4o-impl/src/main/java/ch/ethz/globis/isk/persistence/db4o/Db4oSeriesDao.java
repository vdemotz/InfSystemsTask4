package ch.ethz.globis.isk.persistence.db4o;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.Series;
import ch.ethz.globis.isk.domain.db4o.DomainSeries;
import ch.ethz.globis.isk.persistence.SeriesDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class Db4oSeriesDao extends Db4oDao<String, Series> implements SeriesDao {

    @Override
    protected Class<Series> getStoredClass() {
        return Series.class;
    }

    @Override
    public Series createEntity() {
        return new DomainSeries();
    }

    @Override
    public Series findOneByName(String name) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put(PersistenceAttributes.NAME.toString(), new Filter(Operator.EQUAL, name));
        return findOneByFilter(filterMap);
    }
}
