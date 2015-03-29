package ch.ethz.globis.isk.domain.mongo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.ethz.globis.isk.domain.Article;
import ch.ethz.globis.isk.domain.Journal;
import ch.ethz.globis.isk.domain.JournalEdition;

@Document 
public class DomainJournalEdition extends DomainDomainObject implements JournalEdition {


    private String number;
    private String volume;
    private Integer year;

    @DBRef(lazy = false)
    private Journal journal;

    @DBRef(lazy = true)
    private Set<Article> publications;

    public DomainJournalEdition() {
        publications = new HashSet<>();
    }

    public void addArticle(Article publication) {
        publications.add(publication);
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Article> getPublications() {
        return publications;
    }

    public void setPublications(Set<Article> publications) {
        this.publications = publications;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "JournalEdition{" +
                "year=" + getYear() +
                ", volume='" +  getYear() + '\'' +
                ", number='" +  getYear() + '\'' +
                ", id='" +  getYear() + '\'' +
                '}';
    }
}