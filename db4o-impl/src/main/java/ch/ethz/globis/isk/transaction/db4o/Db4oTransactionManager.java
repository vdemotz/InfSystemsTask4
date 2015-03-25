package ch.ethz.globis.isk.transaction.db4o;

import ch.ethz.globis.isk.config.PersistenceConfig;
import ch.ethz.globis.isk.service.cache.RequestResultCache;
import ch.ethz.globis.isk.transaction.CacheAwareTransactionManager;

import com.db4o.ObjectContainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Db4oTransactionManager extends CacheAwareTransactionManager {

    @Autowired
    RequestResultCache cache;

    @Autowired
    //@Qualifier(PersistenceConfig.OC_QUALIFIER)
    private ObjectContainer oc;
	
	@Override
    public void rollback() {
		oc.rollback();
    }

    @Override
    public void begin() {
        //no need for explicit begin
    }

    @Override
    public void commit() {
    	oc.commit();
    }
}
