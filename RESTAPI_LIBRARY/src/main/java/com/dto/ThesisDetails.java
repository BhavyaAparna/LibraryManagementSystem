package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class ThesisDetails {
	@Id@GeneratedValue
	private int thesisId;
	private String thesisName;
	private String thesisAuthor;
	private String thesisSubject;
	private int thesisPublishingYear;
	
	@ManyToOne
	private FacultyDetails facultyDetails;
	
	public int getThesisId() {
		return thesisId;
	}
	public void setThesisId(int thesisId) {
		this.thesisId = thesisId;
	}
	public String getThesisName() {
		return thesisName;
	}
	public void setThesisName(String thesisName) {
		this.thesisName = thesisName;
	}
	public String getThesisAuthor() {
		return thesisAuthor;
	}
	public void setThesisAuthor(String thesisAuthor) {
		this.thesisAuthor = thesisAuthor;
	}
	public String getThesisSubject() {
		return thesisSubject;
	}
	public void setThesisSubject(String thesisSubject) {
		this.thesisSubject = thesisSubject;
	}
	public int getThesisPublishingYear() {
		return thesisPublishingYear;
	}
	public void setThesisPublishingYear(int thesisPublishingYear) {
		this.thesisPublishingYear = thesisPublishingYear;
	}
	public FacultyDetails getFacultyDetails() {
		return facultyDetails;
	}
	public void setFacultyDetails(FacultyDetails facultyDetails) {
		this.facultyDetails = facultyDetails;
	}
	@Override
	public String toString() {
		return "ThesisDetails [thesisId=" + thesisId + ", thesisName=" + thesisName + ", thesisAuthor=" + thesisAuthor
				+ ", thesisSubject=" + thesisSubject + ", thesisPublishingYear=" + thesisPublishingYear
				+ ", facultyDetails=" + facultyDetails + "]";
	}
	
	
	
	

}
