package ch.ethz.globis.isk.persistence.db4o;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.Person;
import ch.ethz.globis.isk.domain.db4o.DomainPerson;
import ch.ethz.globis.isk.persistence.PersonDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class Db4oPersonDao extends Db4oDao<String, Person> implements PersonDao  {

    @Override
    protected Class<Person> getStoredClass() {
        return Person.class;
    }

    @Override
    public Person createEntity() {
        return new DomainPerson();
    }

    @Override
    public Person findOneByName(String name) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put(PersistenceAttributes.NAME.toString(), new Filter(Operator.EQUAL, name));
        return findOneByFilter(filterMap);
    }

}
