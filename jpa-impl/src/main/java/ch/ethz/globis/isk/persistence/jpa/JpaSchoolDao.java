package ch.ethz.globis.isk.persistence.jpa;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.School;
import ch.ethz.globis.isk.domain.jpa.JpaSchool;
import ch.ethz.globis.isk.persistence.SchoolDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class JpaSchoolDao extends JpaDao<String, School> implements SchoolDao {

    @Override
    protected Class<JpaSchool> getStoredClass() {
        return JpaSchool.class;
    }

    @Override
    public School createEntity() {
        return new JpaSchool();
    }

    @Override
    public School findOneByName(String name) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("name", new Filter(Operator.EQUAL, name));
        return findOneByFilter(filterMap);
    }
}