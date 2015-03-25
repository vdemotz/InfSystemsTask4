package ch.ethz.globis.isk.persistence.mongo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import ch.ethz.globis.isk.domain.DomainObject;
import ch.ethz.globis.isk.persistence.Dao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.OrderFilter;

public abstract class MongoDao<K extends Serializable, T extends DomainObject> implements Dao<K, T> {

    @Autowired
    @Qualifier("MongoOperations")
    MongoOperations mo;

    @Override
    public long countAllByFilter(Map<String, Filter> filterMap) {
        Query query = selectQueryFromFilterMap(filterMap, null);
        return mo.count(query, getStoredClass());
    }

    @Override
    public long count() {
        return mo.count(null, getStoredClass());
    }

    @Override
    public Iterable<T> findAll() {
        return mo.findAll(getStoredClass());
    }

    @Override
    public T findOne(K id) {
    	return mo.findById(id, getStoredClass());
    }

    @Override
    public T findOneByFilter(Map<String, Filter> filterMap) {
        Query query = selectQueryFromFilterMap(filterMap, null);
        return mo.findOne(query, getStoredClass());
    }

    @Override
    public Iterable<T> findAllByFilter(Map<String, Filter> filterMap) {
    	Query query = selectQueryFromFilterMap(filterMap, null);
        return mo.find(query, getStoredClass());
    }

    @Override
    public Iterable<T> findAllByFilter(Map<String, Filter> filterMap, int start, int size) {
        return findAllByFilter(filterMap, null, start, size);
    }

    @Override
    public Iterable<T> findAllByFilter(Map<String, Filter> filterMap,
                                       List<OrderFilter> orderList,
                                       int start, int size) {
    	Query query = selectQueryFromFilterMap(filterMap, orderList);
        return mo.find(query.skip(start).limit(size), getStoredClass());
    }

    @Override
    public Iterable<T> findAllByFilter(Map<String, Filter> filterMap,
                                       List<OrderFilter> orderList) {
    	Query query = selectQueryFromFilterMap(filterMap, orderList);
        return mo.find(query, getStoredClass());
    }

    @Override
    public <S extends T> Iterable<S> insert(Iterable<S> entities) {
        for (S entity : entities){
        	insert(entity);
        }
        return entities;
    }

    @Override
    public <S extends T> S insert(S entity) {
    	mo.save(entity);
        return entity;
    }

    protected abstract <S extends T> Class<S> getStoredClass();

    private Query selectQueryFromFilterMap(Map<String, Filter> filterMap,
                                                      List<OrderFilter> orderList) {
        Query query = new Query();

    	if (filterMap != null){
	    	for (String attribute : filterMap.keySet()){
	    		switch (filterMap.get(attribute).getOperator()){
		    		case STRING_MATCH:
		    			query.addCriteria(Criteria.where(attribute).regex(filterMap.get(attribute).getValue().toString()));
		    			break;
		    		case EQUAL:
		    			query.addCriteria(Criteria.where(attribute).is(filterMap.get(attribute).getValue()));
		    			break;
	    		}
	    	}
    	}
    	
    	if (orderList != null && !orderList.isEmpty()){
    		List<Order> oList = new ArrayList<Order>();
    		for (OrderFilter filter : orderList){
    			switch (filter.getOrder()){
	    			case ASC:
	    				oList.add(new Order(Direction.ASC, filter.getField()));
	    				break;
	    			case DESC:
	    				oList.add(new Order(Direction.DESC, filter.getField()));
	    				break;
    			}
    		}
    		query.with(new Sort(oList));
    	}
    	return query;
    }
}