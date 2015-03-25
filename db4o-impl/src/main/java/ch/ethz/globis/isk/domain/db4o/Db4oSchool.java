package ch.ethz.globis.isk.domain.db4o;

import ch.ethz.globis.isk.domain.Publication;
import ch.ethz.globis.isk.domain.School;

import java.util.HashSet;
import java.util.Set;

public class Db4oSchool extends Db4oDomainObject implements School {

    private String name;

    private Set<Publication> publications;

    public Db4oSchool() {
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
        final StringBuffer sb = new StringBuffer("School{");
        sb.append("id=").append(getId());
        sb.append(", name='").append(getName()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}