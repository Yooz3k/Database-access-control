package bsk_project.databaseaccesscontrol.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Producer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int producerId;
    
    String name;
    String country;
    
   /* @OneToMany
    List<Part> parts;*/

    public Producer(String name, String country) {
        this.name = name;
        this.country = country;
    }
    
    public Producer(int producerId, String name, String country) {
        this.producerId = producerId;
        this.name = name;
        this.country = country;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerID) {
        this.producerId = producerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
/*
	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}*/

	@Override
	public String toString() {
		return "Producer [producerId=" + producerId + ", name=" + name + ", country=" + country + "]";
	}
    
    
}
