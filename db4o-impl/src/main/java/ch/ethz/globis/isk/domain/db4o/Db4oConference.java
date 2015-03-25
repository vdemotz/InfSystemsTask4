package ch.ethz.globis.isk.domain.db4o;

import ch.ethz.globis.isk.domain.Conference;
import ch.ethz.globis.isk.domain.ConferenceEdition;

import java.util.HashSet;
import java.util.Set;

public class Db4oConference extends Db4oDomainObject implements Conference {

    private String name;

    Set<ConferenceEdition> editions;

    public Db4oConference() {
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