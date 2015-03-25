package ch.ethz.globis.isk.domain.db4o;

import ch.ethz.globis.isk.domain.Conference;
import ch.ethz.globis.isk.domain.ConferenceEdition;
import ch.ethz.globis.isk.domain.Proceedings;

public class Db4oConferenceEdition extends Db4oDomainObject implements ConferenceEdition {

    private Integer year;

    private Conference conference;

    private Proceedings proceedings;

    public Db4oConferenceEdition() {
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
