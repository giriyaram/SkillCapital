package com.dl.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreateNewLead {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotEmpty(message = "Name is Mandatory")
	@Size(min = 3, max = 30, message = "Name must be greater than 3 characters")
	private String name;
	
	@NotNull(message = "Country code cannot be null")
	@Positive(message = "Country code can be only positive")
	//@Pattern(regexp = "\\d+", message = "Country code must only conatin digits")
	private Long cc; // country code
	
	@NotNull(message = "ContactNo is Mandatory")
	private Long contactNo;
	
	@NotEmpty(message = "Email is Mandatory")
	private String email;
	
	@Digits(fraction = 0, integer = 5)
	@Max(value = 80000, message = "Fee Cannot be grater than 30001")
	@Min(value = 10000, message = "Fee Cannot be less than 9999")
	@NotNull(message = "Fee cannot be null")
	private Double feeCoated;


    private String description; 

    private Date date; 


	public CreateNewLead(LeadStatus leadStatus, LeadSource leadsource, Stack stack, Courses courses,
			ClassMode classMode, BatchTiming batchTiming) {
		this.leadStatus = leadStatus;
		this.leadsource = leadsource;
		this.stack = stack;
		this.courses = courses;
		this.classMode = classMode;
		this.batchTiming = batchTiming;
	}



	@Enumerated(EnumType.STRING)
	private LeadStatus leadStatus;
	
	@Enumerated(EnumType.STRING)
	private LeadSource leadsource;
	
	@Enumerated(EnumType.STRING)
	private Stack stack;
	
	@Enumerated(EnumType.STRING)
	private Courses courses;

	@Enumerated(EnumType.STRING)
	private ClassMode classMode;
	
	@Enumerated(EnumType.STRING)
	private BatchTiming batchTiming;
	
	@Getter
	@AllArgsConstructor
	public enum LeadStatus {

		None, NotContacted, Attempted, WarmLead, Opportunity, ColdLead

	}

	@Getter
	@AllArgsConstructor
	public enum LeadSource {
		None, WalkIn, StudentReferral, Demo, WebSite, WebsiteChat, InboundCall, GoogleAdWords, FacebookAds,
		GoogleMyBusiness, WhatsApp
	}

	@Getter
	@AllArgsConstructor
	public enum Stack {
		LifeSkills, StudyAbroad, HR,
	}

	@Getter
	@AllArgsConstructor
	public enum Courses {
		PublicSpeaking, PTE,
	}

	@Getter
	@AllArgsConstructor
	public enum ClassMode {
		HYDClassRoom, BLRClassRoom, IndiaOnline, InternationalOnline
	}

	@Getter
	public enum BatchTiming {
		SEVEN_AM_TO_EIGHT_AM("7AM-8AM"), EIGHT_AM_TO_NINE_AM("8AM-9AM"), NINE_AM_TO_TEN_AM("9AM-10AM"),
		TEN_AM_TO_ELEVEN_AM("10AM-11AM"), ELEVEN_AM_TO_TWELVE_PM("11AM-12PM"), TWELVE_PM_TO_ONE_PM("12PM-1PM"),
		ONE_PM_TO_TWO_PM("1PM-2PM"), TWO_PM_TO_THREE_PM("2PM-3PM"), THREE_PM_TO_FOUR_PM("3PM-4PM"),
		FOUR_PM_TO_FIVE_PM("4PM-5PM"), FIVE_PM_TO_SIX_PM("5PM-6PM"), SIX_PM_TO_SEVEN_PM("6PM-7PM"),
		SEVEN_PM_TO_EIGHT_PM("7PM-8PM"), EIGHT_PM_TO_NINE_PM("8PM-9PM");

		private final String timing;

		BatchTiming(String timing) {
			this.timing = timing;
		}
	}

}