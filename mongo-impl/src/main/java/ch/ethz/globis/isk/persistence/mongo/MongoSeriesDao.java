package ch.ethz.globis.isk.persistence.mongo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.Series;
import ch.ethz.globis.isk.domain.mongo.MongoSeries;
import ch.ethz.globis.isk.persistence.SeriesDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class MongoSeriesDao extends MongoDao<String, Series> implements SeriesDao {

    @Override
    protected Class<MongoSeries> getStoredClass() {
        return MongoSeries.class;
    }

    @Override
    public Series createEntity() {
        return new MongoSeries();
    }

    @Override
    public Series findOneByName(String name) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("name", new Filter(Operator.EQUAL, name));
        return findOneByFilter(filterMap);
    }
}