package ch.ethz.globis.isk.persistence.db4o;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.InProceedings;
import ch.ethz.globis.isk.domain.Proceedings;
import ch.ethz.globis.isk.domain.db4o.DomainInProceedings;
import ch.ethz.globis.isk.persistence.InProceedingsDao;
import ch.ethz.globis.isk.persistence.ProceedingsDao;
import ch.ethz.globis.isk.persistence.db4o.Db4oPublicationDao.SortByYearAscendingComparator;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class Db4oInProceedingsDao extends Db4oDao<String, InProceedings> implements InProceedingsDao {
	
	@Autowired
	ProceedingsDao proceedingsDao;

    @Override
    public InProceedings findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put(PersistenceAttributes.TITLE.toString(), new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }

    @Override
    public List<InProceedings> findByProceedingsIdOrderByYear(String proceedingsId) {
        Proceedings proc = proceedingsDao.findOne(proceedingsId);
        List<InProceedings> pubs = new ArrayList<InProceedings>(proc.getPublications());
        Collections.sort(pubs, new SortByYearAscendingComparator());
    	return pubs;
    }

    @Override
    protected Class<InProceedings> getStoredClass() {
        return InProceedings.class;
    }

    @Override
    public InProceedings createEntity() {
        return new DomainInProceedings();
    }

}
