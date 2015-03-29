package ch.ethz.globis.isk.persistence.mongo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.Person;
import ch.ethz.globis.isk.domain.mongo.DomainPerson;
import ch.ethz.globis.isk.persistence.PersonDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class MongoPersonDao extends MongoDao<String, Person> implements PersonDao {

    @Override
    protected Class<DomainPerson> getStoredClass() {
        return DomainPerson.class;
    }

    @Override
    public Person createEntity() {
        return new DomainPerson();
    }

    @Override
    public Person findOneByName(String name) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("name", new Filter(Operator.EQUAL, name));
        return findOneByFilter(filterMap);
    }
}