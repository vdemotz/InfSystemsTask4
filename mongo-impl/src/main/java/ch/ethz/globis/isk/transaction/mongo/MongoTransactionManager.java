package ch.ethz.globis.isk.transaction.mongo;

import org.springframework.stereotype.Component;

import ch.ethz.globis.isk.transaction.CacheAwareTransactionManager;

@Component
public class MongoTransactionManager extends CacheAwareTransactionManager {

    @Override
    public void begin() {
    	//stub
    }

    @Override
    public void commit() {
    	//stub
    }

    @Override
    public void rollback() {
    	//stub
    }
}