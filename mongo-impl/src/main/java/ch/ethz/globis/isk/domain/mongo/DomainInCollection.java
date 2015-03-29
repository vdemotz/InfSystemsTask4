package ch.ethz.globis.isk.domain.mongo;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.ethz.globis.isk.domain.Book;
import ch.ethz.globis.isk.domain.InCollection;

@Document(collection = "publication")
public class DomainInCollection extends DomainPublication implements InCollection {

    private String note;
    private String pages;
    
    @DBRef(lazy = false)
    private Book parentPublication;

    public DomainInCollection() { }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public Book getParentPublication() {
        return parentPublication;
    }

    public void setParentPublication(Book book) {
        this.parentPublication = book;
    }
}