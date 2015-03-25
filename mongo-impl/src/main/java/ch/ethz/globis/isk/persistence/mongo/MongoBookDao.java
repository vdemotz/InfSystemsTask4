package ch.ethz.globis.isk.persistence.mongo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.Book;
import ch.ethz.globis.isk.domain.mongo.MongoBook;
import ch.ethz.globis.isk.persistence.BookDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class MongoBookDao extends MongoDao<String, Book> implements BookDao {

    @Override
    protected Class<MongoBook> getStoredClass() {
        return MongoBook.class;
    }

    @Override
    public Book createEntity() {
        return new MongoBook();
    }

    @Override
    public Book findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("title", new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }
}