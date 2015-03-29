package ch.ethz.globis.isk.domain.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.ethz.globis.isk.domain.DomainObject;

@Document
public class DomainDomainObject implements DomainObject {

	@Id
	protected String id;
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object o){
		if (o.getClass() != this.getClass()){
			return false;
		}
		DomainObject other = (DomainObject)o;
		return other.getId().equals(id);
	}

}
