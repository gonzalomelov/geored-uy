package org.gonzalomelov.georeduy.dal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Person implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3910258006369491463L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	@Column(unique=true)
	@Email
	private String email;
	
	@NotBlank
	@Length(min=4,max=25)
	private String password;
	
	@NotNull
	private String name;
	
	@NotNull
	private String lastname;
	
	private Boolean isLogged = false;
	
	public Person(){}
	
	public Person(String email, String password, String name, String lastname){
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", lastname="
				+ lastname + "]";
	}
	

}