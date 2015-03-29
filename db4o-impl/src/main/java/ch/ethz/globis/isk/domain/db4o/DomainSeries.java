package ch.ethz.globis.isk.domain.db4o;


import ch.ethz.globis.isk.domain.Publication;
import ch.ethz.globis.isk.domain.Series;

import java.util.HashSet;
import java.util.Set;

public class DomainSeries extends DomainDomainObject implements Series {

    private String name;

    private Set<Publication> publications;

    public DomainSeries() {
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