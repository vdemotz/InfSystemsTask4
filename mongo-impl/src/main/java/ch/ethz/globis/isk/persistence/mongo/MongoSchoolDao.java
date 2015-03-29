package ch.ethz.globis.isk.persistence.mongo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.School;
import ch.ethz.globis.isk.domain.mongo.DomainSchool;
import ch.ethz.globis.isk.persistence.SchoolDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class MongoSchoolDao extends MongoDao<String, School> implements SchoolDao {

    @Override
    protected Class<DomainSchool> getStoredClass() {
        return DomainSchool.class;
    }

    @Override
    public School createEntity() {
        return new DomainSchool();
    }

    @Override
    public School findOneByName(String name) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("name", new Filter(Operator.EQUAL, name));
        return findOneByFilter(filterMap);
    }
}