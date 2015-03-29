package ch.ethz.globis.isk.persistence.mongo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.Article;
import ch.ethz.globis.isk.domain.JournalEdition;
import ch.ethz.globis.isk.domain.mongo.DomainArticle;
import ch.ethz.globis.isk.persistence.ArticleDao;
import ch.ethz.globis.isk.persistence.JournalEditionDao;
import ch.ethz.globis.isk.persistence.mongo.MongoPublicationDao.SortByYearAscendingComparator;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class MongoArticleDao extends MongoDao<String, Article> implements ArticleDao {
	
	@Autowired
	JournalEditionDao journalDao;

    @Override
    protected Class<DomainArticle> getStoredClass() {
        return DomainArticle.class;
    }

    @Override
    public Article createEntity() {
        return new DomainArticle();
    }

    @Override
    public Article findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("title", new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }

    @Override
    public List<Article> findByJournalEditionOrderedByYear(String journalEditionId) {
        JournalEdition edition = journalDao.findOne(journalEditionId);
        List<Article> pubs = new ArrayList<Article>(edition.getPublications());
        Collections.sort(pubs, new SortByYearAscendingComparator());
    	return pubs;
    }
}