package ch.ethz.globis.isk.persistence.jpa;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.Person;
import ch.ethz.globis.isk.domain.jpa.JpaPerson;
import ch.ethz.globis.isk.persistence.PersonDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class JpaPersonDao extends JpaDao<String, Person> implements PersonDao {

    @Override
    protected Class<JpaPerson> getStoredClass() {
        return JpaPerson.class;
    }

    @Override
    public Person createEntity() {
        return new JpaPerson();
    }

    @Override
    public Person findOneByName(String name) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("name", new Filter(Operator.EQUAL, name));
        return findOneByFilter(filterMap);
    }
}