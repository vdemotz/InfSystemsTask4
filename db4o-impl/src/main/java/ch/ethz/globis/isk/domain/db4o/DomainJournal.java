package ch.ethz.globis.isk.domain.db4o;

import ch.ethz.globis.isk.domain.Journal;
import ch.ethz.globis.isk.domain.JournalEdition;

import java.util.HashSet;
import java.util.Set;

public class DomainJournal extends DomainDomainObject implements Journal {

    private String name;

    private Set<JournalEdition> editions;

    public DomainJournal() {
        this.editions = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<JournalEdition> getEditions() {
        return editions;
    }

    public void addEdition(JournalEdition edition) {
        editions.add(edition);
    }
    public void setEditions(Set<JournalEdition> editions) {
        this.editions = editions;
    }
}