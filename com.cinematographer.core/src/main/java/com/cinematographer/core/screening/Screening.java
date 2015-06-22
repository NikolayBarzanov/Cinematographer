package com.cinematographer.core.screening;

import java.sql.Time;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SCREENING")
public class Screening {

	@Id
	@NotNull
	private String title;
	private Time startTime;
	private Time duration;
	@OneToMany
	private Collection<Seat> seats;
	private Integer hall;
        private Double prise;

	public Screening() {

	}

	public Screening(String title, Time startTime, Time duration,
			Collection<Seat> seats, int hall, double prise) {
		this.title = title;
		this.startTime = startTime;
		this.duration = duration;
		this.seats = seats;
		this.hall = hall;
                this.prise = prise;
	}

        public Double getPrise()
        {
            return prise;
        }       
        

	public Time getDuration() {
		return duration;
	}

	public int getHall() {
		return hall;
	}

	public String getTitle() {
		return title;
	}

	public Collection<Seat> getSeats() {
		return seats;
	}

	public Time getStartTime() {
		return startTime;
	}

        public void setPrise(Double prise)
        {
            this.prise = prise;
        }      
        
	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public void setHall(int hall) {
		this.hall = hall;
	}

	public void setSeats(Collection<Seat> seats) {
		this.seats = seats;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((hall == null) ? 0 : hall.hashCode());
		result = prime * result + ((seats == null) ? 0 : seats.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
                result = prime * result + ((prise == null) ? 0 : prise.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screening other = (Screening) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (hall == null) {
			if (other.hall != null)
				return false;
		} else if (!hall.equals(other.hall))
			return false;
		if (seats == null) {
			if (other.seats != null)
				return false;
		} else if (!seats.equals(other.seats))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
                if (prise == null) {
			if (other.prise != null)
				return false;
		} else if (!prise.equals(other.prise))
			return false;
		return true;
	}

}
