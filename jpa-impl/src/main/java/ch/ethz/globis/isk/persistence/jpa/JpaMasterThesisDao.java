package ch.ethz.globis.isk.persistence.jpa;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.MasterThesis;
import ch.ethz.globis.isk.domain.jpa.JpaMasterThesis;
import ch.ethz.globis.isk.persistence.MasterThesisDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class JpaMasterThesisDao extends JpaDao<String, MasterThesis> implements MasterThesisDao {

    @Override
    protected Class<JpaMasterThesis> getStoredClass() {
        return JpaMasterThesis.class;
    }

    @Override
    public MasterThesis findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("title", new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }

    @Override
    public MasterThesis createEntity() {
        return new JpaMasterThesis();
    }
}