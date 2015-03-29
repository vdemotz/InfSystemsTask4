package ch.ethz.globis.isk.persistence.db4o;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.School;
import ch.ethz.globis.isk.domain.db4o.DomainSchool;
import ch.ethz.globis.isk.persistence.SchoolDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class Db4oSchoolDao extends Db4oDao<String, School> implements SchoolDao {

    @Override
    protected Class<School> getStoredClass() {
        return School.class;
    }

    @Override
    public School createEntity() {
        return new DomainSchool();
    }

    @Override
    public School findOneByName(String name) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put(PersistenceAttributes.NAME.toString(), new Filter(Operator.EQUAL, name));
        return findOneByFilter(filterMap);
    }

}
