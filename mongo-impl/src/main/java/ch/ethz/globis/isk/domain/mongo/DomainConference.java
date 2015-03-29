package ch.ethz.globis.isk.domain.mongo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.ethz.globis.isk.domain.Conference;
import ch.ethz.globis.isk.domain.ConferenceEdition;


@Document 
public class DomainConference extends DomainDomainObject implements Conference {

    private String name;

    @DBRef(lazy = true)
    Set<ConferenceEdition> editions;

    public DomainConference() {
        editions = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ConferenceEdition> getEditions() {
        return editions;
    }

    public void setEditions(Set<ConferenceEdition> editions) {
        this.editions = editions;
    }
}