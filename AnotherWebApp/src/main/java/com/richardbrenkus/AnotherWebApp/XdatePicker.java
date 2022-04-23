package com.richardbrenkus.AnotherWebApp;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;



public class XdatePicker {
	
	@NotNull(message = "Select")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
    private List<Date> dates;

	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}
	
}
