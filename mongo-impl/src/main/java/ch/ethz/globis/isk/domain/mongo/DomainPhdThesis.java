package ch.ethz.globis.isk.domain.mongo;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.ethz.globis.isk.domain.PhdThesis;
import ch.ethz.globis.isk.domain.Publisher;
import ch.ethz.globis.isk.domain.School;

@Document(collection = "publication")
public class DomainPhdThesis extends DomainPublication implements PhdThesis {

    private Integer month;
    private String note;
    private Integer number;
    private String isbn;

    @DBRef(lazy = false)
    private Publisher publisher;
    
    @DBRef(lazy = false)
    private School school;

    public DomainPhdThesis() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}