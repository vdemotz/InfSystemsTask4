package ch.ethz.globis.isk.domain.db4o;

import ch.ethz.globis.isk.domain.MasterThesis;
import ch.ethz.globis.isk.domain.School;

public class Db4oMasterThesis extends Db4oPublication implements MasterThesis {

    private School school;

    public Db4oMasterThesis() { }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}