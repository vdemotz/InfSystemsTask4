package ch.ethz.globis.isk.domain.mongo;


import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.ethz.globis.isk.domain.Book;
import ch.ethz.globis.isk.domain.InCollection;
import ch.ethz.globis.isk.domain.Publisher;
import ch.ethz.globis.isk.domain.Series;

@Document(collection = "publication")
public class MongoBook extends MongoPublication implements Book {

    private String cdrom;
    private Integer month;
    private String volume;
    private String isbn;

    @DBRef(lazy=false)
    private Series series;

    @DBRef(lazy=false)
    private Publisher publisher;

    @DBRef(lazy=true)
    private Set<InCollection> publications;

    public MongoBook() {
        publications = new HashSet<>();
    }

    public String getCdrom() {
        return cdrom;
    }

    public void setCdrom(String cdrom) {
        this.cdrom = cdrom;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public Set<InCollection> getPublications() {
        return publications;
    }

    @Override
    public void setPublications(Set<InCollection> publications) {
        this.publications = publications;
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}