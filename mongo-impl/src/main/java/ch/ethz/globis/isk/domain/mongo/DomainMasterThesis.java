package ch.ethz.globis.isk.domain.mongo;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.ethz.globis.isk.domain.MasterThesis;
import ch.ethz.globis.isk.domain.School;

@Document(collection = "publication")
public class DomainMasterThesis extends DomainPublication implements MasterThesis {

	@DBRef(lazy = false)
	private School school;

    public DomainMasterThesis() { }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}