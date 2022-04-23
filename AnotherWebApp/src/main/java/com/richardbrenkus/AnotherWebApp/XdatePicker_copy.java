package com.richardbrenkus.AnotherWebApp;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


public class XdatePicker_copy {

/*	
	@Transient
//	@NotNull(message = "Select")
//	@DateTimeFormat(pattern = "MM/dd/yyyy")
//	@ElementCollection
	@Column(name = "dates")
    private List<LocalDateTime> dates;
   

//	@Transient
	@NotNull(message = "Select")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDateTime date;
	
	@Id
	@Column(name = "request_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long requestID;
	
	@Transient
	private User user;

	/*
	@OneToOne   
    @JoinTable(
            name = "users_requests",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "request_id")
            )        
    private Collection<XdatePicker> requests = new LinkedHashSet<>();;


	public Long getRequestID() {
		return requestID;
	}

	public void setRequestID(Long requestID) {
		this.requestID = requestID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	*/   
	
/*
	public List<LocalDateTime> getDates() {
		return dates;
	}

	public void setDates(List<LocalDateTime> dates) {
		this.dates = dates;
	}
*/
}
