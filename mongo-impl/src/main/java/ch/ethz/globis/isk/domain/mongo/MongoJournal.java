package ch.ethz.globis.isk.domain.mongo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.ethz.globis.isk.domain.Journal;
import ch.ethz.globis.isk.domain.JournalEdition;

@Document 
public class MongoJournal extends MongoDomainObject implements Journal {

    private String name;

    @DBRef(lazy = true)
    private Set<JournalEdition> editions;

    public MongoJournal() {
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