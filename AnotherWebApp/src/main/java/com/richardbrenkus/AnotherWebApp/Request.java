package com.richardbrenkus.AnotherWebApp;

import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "requests")
public class Request {
	
	@Id
	@Column(name = "request_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long request_id;
	
	@JsonBackReference
	@OneToOne(mappedBy = "request_user")
	private User user;

	public Long getRequest_id() {
		return request_id;
	}
	public void setRequest_id(Long request_id) {
		this.request_id = request_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "dates")
	private String dates;
	
	@ElementCollection
	@Column(name = "datesList")
	private List<Date> datesList = new ArrayList<Date>();
	
	public Long getRequestId() {
		return request_id;
	}
	public List<Date> getDatesList() {
		return datesList;
	}
	public void setDatesList(List<Date> datesList) {
		this.datesList = datesList;
	}
	public void setRequestId(Long request_id) {
		this.request_id = request_id;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}

	
	public void setDateToString(List<Date> date) {
		dates = date.toString();
	}
	/*
	public List<String> convertStringToDateList(){
		List<Date> dateDates = new ArrayList();
		List<String> stringDates = new ArrayList();
		
		stringDates = DateUtils.pa
		
		stringDates.a
	}
	*/
	
	
}

