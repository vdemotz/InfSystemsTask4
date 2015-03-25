package ch.ethz.globis.isk.domain.mongo;


import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.ethz.globis.isk.domain.Publication;
import ch.ethz.globis.isk.domain.Series;

@Document 
public class MongoSeries extends MongoDomainObject implements Series {

    private String name;

    @DBRef(lazy = true)
    private Set<Publication> publications;

    public MongoSeries() {
        publications = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Set<Publication> getPublications() {
        return publications;
    }

    @Override
    public void setPublications(Set<Publication> publications) {
        this.publications = publications;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Series{");
        sb.append(", id='").append(getId()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}