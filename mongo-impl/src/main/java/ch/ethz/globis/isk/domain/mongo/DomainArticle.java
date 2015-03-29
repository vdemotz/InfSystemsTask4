package ch.ethz.globis.isk.domain.mongo;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.ethz.globis.isk.domain.Article;
import ch.ethz.globis.isk.domain.JournalEdition;

@Document(collection = "publication")
public class DomainArticle extends DomainPublication implements Article {

    private String cdrom;
    private String pages;

    @DBRef(lazy=false)
    private JournalEdition journalEdition;

    public DomainArticle() {};

    public String getCdrom() {
        return cdrom;
    }

    public void setCdrom(String cdrom) {
        this.cdrom = cdrom;
    }

    public JournalEdition getJournalEdition() {
        return journalEdition;
    }

    public void setJournalEdition(JournalEdition journalEdition) {
        this.journalEdition = journalEdition;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }
}