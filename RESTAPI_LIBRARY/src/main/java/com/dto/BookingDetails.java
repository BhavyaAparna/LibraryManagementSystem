package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class BookingDetails {
	
	@Id@GeneratedValue
	private int bookId;
	private int bookrId;
	private String bookName;
	private String booksubject;
	private String bookAuthor;
	private String bookDate;
	private int studentId;
	private String studentName;
	private String studentNumber;
	private String studentSection;
	private String studentBranch;
	private String studentEmail;
	private String itemStatus;
	private int bookCount;
	

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookrId() {
		return bookrId;
	}

	public void setBookrId(int bookrId) {
		this.bookrId = bookrId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBooksubject() {
		return booksubject;
	}

	public void setBooksubject(String booksubject) {
		this.booksubject = booksubject;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentSection() {
		return studentSection;
	}

	public void setStudentSection(String studentSection) {
		this.studentSection = studentSection;
	}

	public String getStudentBranch() {
		return studentBranch;
	}

	public void setStudentBranch(String studentBranch) {
		this.studentBranch = studentBranch;
	}
	
	
	

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	
	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	
	
	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	@Override
	public String toString() {
		return "BookingDetails [bookId=" + bookId + ", bookrId=" + bookrId + ", bookName=" + bookName + ", booksubject="
				+ booksubject + ", bookAuthor=" + bookAuthor + ", bookDate=" + bookDate + ", studentId=" + studentId
				+ ", studentName=" + studentName + ", studentNumber=" + studentNumber + ", studentSection="
				+ studentSection + ", studentBranch=" + studentBranch + ", studentEmail=" + studentEmail
				+ ", itemStatus=" + itemStatus + ", bookCount=" + bookCount + "]";
	}

	

	
	
	
	

}
