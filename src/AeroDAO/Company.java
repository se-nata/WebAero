package AeroDAO;

import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company implements Serializable {

@Id
@GeneratedValue(strategy = IDENTITY)
@Column(name="id_comp")	
private int idComp;	
@Column(name="name")
private String name;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public int getIdComp() {
	return idComp;
}
public void setIdComp(int idComp) {
	this.idComp = idComp;
}
public Company() {}
public Company(String name) {
	this.name=name;
Company company=new Company();
}

@Override
public String toString() {
	return "Company [idComp=" + idComp + ", name=" + name + "]";
}
}
