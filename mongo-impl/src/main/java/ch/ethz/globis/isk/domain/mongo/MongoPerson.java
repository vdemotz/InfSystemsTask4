package ch.ethz.globis.isk.domain.mongo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.ethz.globis.isk.domain.Person;
import ch.ethz.globis.isk.domain.Publication;

@Document 
public class MongoPerson extends MongoDomainObject implements Person {

    private String name;

    @DBRef(lazy = true)
    public Set<Publication> authoredPublications;

    @DBRef(lazy = true)
    public Set<Publication> editedPublications;

    public MongoPerson() {
        authoredPublications = new HashSet<>();
        editedPublications = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Publication> getAuthoredPublications() {
        return authoredPublications;
    }

    public void setAuthoredPublications(Set<Publication> publications) {
        this.authoredPublications = publications;
    }

    public Set<Publication> getEditedPublications() {
        return editedPublications;
    }

    public void setEditedPublications(Set<Publication> editedPublications) {
        this.editedPublications = editedPublications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getId() != null ? !getId().equals(person.getId()) : person.getId() != null) return false;
        if (getName() != null ? !getName().equals(person.getName()) : person.getName() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}