package ch.ethz.globis.isk.domain.mongo;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.ethz.globis.isk.domain.Conference;
import ch.ethz.globis.isk.domain.ConferenceEdition;
import ch.ethz.globis.isk.domain.Proceedings;

@Document 
public class DomainConferenceEdition extends DomainDomainObject implements ConferenceEdition {

	
    private Integer year;
    
    @DBRef(lazy = false)
    private Conference conference;

    @DBRef(lazy = true)
    private Proceedings proceedings;

    public DomainConferenceEdition() {
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public Proceedings getProceedings() {
        return proceedings;
    }

    public void setProceedings(Proceedings proceedings) {
        this.proceedings = proceedings;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ConferenceEdition{" +
                "id='" + getId() + '\'' +
                ", year=" + getYear() +
                '}';
    }
}
