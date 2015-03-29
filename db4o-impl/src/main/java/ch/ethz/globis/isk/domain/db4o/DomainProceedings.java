package ch.ethz.globis.isk.domain.db4o;

import java.util.HashSet;
import java.util.Set;

import ch.ethz.globis.isk.domain.ConferenceEdition;
import ch.ethz.globis.isk.domain.InProceedings;
import ch.ethz.globis.isk.domain.Proceedings;
import ch.ethz.globis.isk.domain.Publisher;
import ch.ethz.globis.isk.domain.Series;

public class DomainProceedings extends DomainPublication implements Proceedings {

    private String note;
    private Integer number;
    private String volume;
    private String isbn;

    private Publisher publisher;

    private Series series;

    private ConferenceEdition conferenceEdition;

    private Set<InProceedings> publications;

    public DomainProceedings() {
        publications = new HashSet<>();
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

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (this.getIsbn() != null) {
            if (this.getNote() == null) {
                this.setNote("");
            }
            this.setNote(this.getNote() + "\nISBN updated, old value was " + this.getIsbn());
        }
        this.isbn = isbn;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public ConferenceEdition getConferenceEdition() {
        return conferenceEdition;
    }

    public void setConferenceEdition(ConferenceEdition conferenceEdition) {
        this.conferenceEdition = conferenceEdition;
    }

    public Set<InProceedings> getPublications() {
        return publications;
    }

    public void setPublications(Set<InProceedings> publications) {
        this.publications = publications;
    }
}