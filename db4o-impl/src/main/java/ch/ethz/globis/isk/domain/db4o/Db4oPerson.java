package ch.ethz.globis.isk.domain.db4o;

import ch.ethz.globis.isk.domain.Person;
import ch.ethz.globis.isk.domain.Publication;

import java.util.HashSet;
import java.util.Set;

public class Db4oPerson implements Person {

    private String id;
    private String name;

    public Set<Publication> authoredPublications;

    public Set<Publication> editedPublications;

    public Db4oPerson() {
        authoredPublications = new HashSet<>();
        editedPublications = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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