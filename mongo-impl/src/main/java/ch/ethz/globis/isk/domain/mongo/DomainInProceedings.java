package ch.ethz.globis.isk.domain.mongo;


import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.ethz.globis.isk.domain.InProceedings;
import ch.ethz.globis.isk.domain.Proceedings;

@Document(collection = "publication")
public class DomainInProceedings extends DomainPublication implements InProceedings {

    private String note;
    private String pages;

    @DBRef(lazy = false)
    private Proceedings proceedings;

    public DomainInProceedings() {}

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

    public Proceedings getProceedings() {
        return proceedings;
    }

    @Override
    public void setProceedings(Proceedings proceedings) {
        this.proceedings = proceedings;
    }

}
