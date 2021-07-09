package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class FacultyDetails {
	@Id@GeneratedValue
	private int facultyId;
	private String facultyName;
	private String facultyEmail;
	private String facultyPassword;
	private String facultyBranch;
	
	@OneToMany(mappedBy="facultyDetails",fetch = FetchType.LAZY)
	private List<BookDetails> bookDetails = new ArrayList<BookDetails>();
	
	@OneToMany(mappedBy="facultyDetails",fetch = FetchType.LAZY)
	private List<ThesisDetails> thesisDetails = new ArrayList<ThesisDetails>();
	
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getFacultyBranch() {
		return facultyBranch;
	}
	public void setFacultyBranch(String facultyBranch) {
		this.facultyBranch = facultyBranch;
	}
	public List<BookDetails> getBookDetails() {
		return bookDetails;
	}
	public void setBookDetails(List<BookDetails> bookDetails) {
		this.bookDetails = bookDetails;
	}
	public List<ThesisDetails> getThesisDetails() {
		return thesisDetails;
	}
	public void setThesisDetails(List<ThesisDetails> thesisDetails) {
		this.thesisDetails = thesisDetails;
	}
	
	public String getFacultyEmail() {
		return facultyEmail;
	}
	public void setFacultyEmail(String facultyEmail) {
		this.facultyEmail = facultyEmail;
	}
	public String getFacultyPassword() {
		return facultyPassword;
	}
	public void setFacultyPassword(String facultyPassword) {
		this.facultyPassword = facultyPassword;
	}
	@Override
	public String toString() {
		return "FacultyDetails [facultyId=" + facultyId + ", facultyName=" + facultyName + ", facultyEmail="
				+ facultyEmail + ", facultyPassword=" + facultyPassword + ", facultyBranch=" + facultyBranch
				+ ", bookDetails=" + bookDetails + ", thesisDetails=" + thesisDetails + "]";
	}
	
	
	
	

}
