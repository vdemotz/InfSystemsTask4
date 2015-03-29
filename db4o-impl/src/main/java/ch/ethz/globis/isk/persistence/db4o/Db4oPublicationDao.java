package ch.ethz.globis.isk.persistence.db4o;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.ethz.globis.isk.domain.Person;
import ch.ethz.globis.isk.domain.Publication;
import ch.ethz.globis.isk.domain.Publisher;
import ch.ethz.globis.isk.domain.School;
import ch.ethz.globis.isk.domain.Series;
import ch.ethz.globis.isk.domain.db4o.DomainPublication;
import ch.ethz.globis.isk.persistence.PersonDao;
import ch.ethz.globis.isk.persistence.PublicationDao;
import ch.ethz.globis.isk.persistence.PublisherDao;
import ch.ethz.globis.isk.persistence.SchoolDao;
import ch.ethz.globis.isk.persistence.SeriesDao;
import ch.ethz.globis.isk.util.Filter;
import ch.ethz.globis.isk.util.Operator;

@Repository
public class Db4oPublicationDao extends Db4oDao<String, Publication> implements PublicationDao {
	
	@Autowired
	SchoolDao schoolDao;
	
	@Autowired
	SeriesDao seriesDao;
	
	@Autowired
	PublisherDao publisherDao;
	
	@Autowired
	PersonDao personDao;

    @Override
    protected Class<Publication> getStoredClass() {
        return Publication.class;
    }

    @Override
    public Publication createEntity() {
        return new DomainPublication();
    }

    @Override
    public Publication findOneByTitle(String title) {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put(PersistenceAttributes.TITLE.toString(), new Filter(Operator.EQUAL, title));
        return findOneByFilter(filterMap);
    }

    @Override
    public List<Publication> findByAuthorIdOrderedByYear(String authorId) {
    	Person author = personDao.findOne(authorId);
        List<Publication> pubs = new ArrayList<Publication>(author.getAuthoredPublications());
        Collections.sort(pubs, new SortByYearAscendingComparator());
    	return pubs;
    }

    @Override
    public List<Publication> findByEditorIdOrderedByYear(String editorId) {
        Person editor = personDao.findOne(editorId);
        List<Publication> pubs = new ArrayList<Publication>(editor.getEditedPublications());
        Collections.sort(pubs, new SortByYearAscendingComparator());
    	return pubs;
    }

    @Override
    public List<Publication> findByPublisherOrderedByYear(String publisherId) {
    	Publisher publisher = publisherDao.findOne(publisherId);
        List<Publication> pubs = new ArrayList<Publication>(publisher.getPublications());
        Collections.sort(pubs, new SortByYearAscendingComparator());
    	return pubs;
    }

    @Override
    public List<Publication> findBySchoolOrderedByYear(String schoolId) {
        School school = schoolDao.findOne(schoolId);
        List<Publication> pubs = new ArrayList<Publication>(school.getPublications());
        Collections.sort(pubs, new SortByYearAscendingComparator());
    	return pubs;
    }

    @Override
    public List<Publication> findBySeriesOrderedByYear(String seriesId) {
    	Series series = seriesDao.findOne(seriesId);
        List<Publication> pubs = new ArrayList<Publication>(series.getPublications());
        Collections.sort(pubs, new SortByYearAscendingComparator());
    	return pubs;
    }
    
    protected static class SortByYearAscendingComparator implements Comparator<Publication>{
    	@Override
		public int compare(Publication o1, Publication o2) {
			return o1.getYear().compareTo(o2.getYear());
		}
    }

}
