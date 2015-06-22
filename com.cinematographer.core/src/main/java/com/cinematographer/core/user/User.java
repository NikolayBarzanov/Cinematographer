package com.cinematographer.core.user;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.cinematographer.core.screening.Reservation;

@Entity
public class User {
	@Id
	@NotNull
	private String name;
	private String password;
	@OneToMany
	private Collection<Reservation> reservations;
	@Enumerated(EnumType.STRING)
	private Role role;

	public User() {
	}

	public User(String name, String password,
			Collection<Reservation> reservations, Role role) {
		this.name = name;
		this.password = password;
		this.reservations = reservations;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public Role getRole() {
		return role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setRole(Role role) {
		this.role = role;
	}

    @Override
    public int hashCode()
    {
        final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		
		return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
	if (obj == null)
            return false;
	if (getClass() != obj.getClass())
            return false;
	User other = (User) obj;
	if (name == null) {
		if (other.name != null)
			return false;
		} else if (!name.equals(other.name))
			return false;
        if (password == null) {
		if (other.password != null)
			return false;
		} else if (!password.equals(other.password))
			return false;
        return true;
    }  
    
}
