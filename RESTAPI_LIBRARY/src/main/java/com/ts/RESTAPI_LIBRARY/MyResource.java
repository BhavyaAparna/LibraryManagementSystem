package com.ts.RESTAPI_LIBRARY;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.dao.BookDAO;
import com.dao.BookingDAO;
import com.dao.FacultyDAO;
import com.dao.StudentDAO;
import com.dao.ThesisDAO;
import com.dto.BookDetails;
import com.dto.BookingDetails;
import com.dto.FacultyDetails;
import com.dto.StudentDetails;
import com.dto.ThesisDetails;
import com.ts.db.HibernateTemplate;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @Path("Hi")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hi() {
		return "Hi Service!";
	}
    
    @Path("registerStudent")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerUser(StudentDetails student) {
		System.out.println("Data Recieved in Student Register : " + student);
		StudentDAO studentDao = new StudentDAO();
		studentDao.register(student);
	}
    
    @Path("registerFaculty")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerFaculty(FacultyDetails faculty) {
		System.out.println("Data Recieved in Faculty Register : " + faculty);
		FacultyDAO facultydao = new FacultyDAO();
		facultydao.register(faculty);
	}
    @Path("getStudentByPass/{studentEmail}/{studentPassword}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getStudentByPass(@PathParam("studentEmail") String studentEmail,@PathParam("studentPassword") String studentPassword) {
		System.out.println("Recieved path params: "+studentEmail+studentPassword); 
		StudentDAO studentDAO = new StudentDAO();
		return studentDAO.getStudentByPass(studentEmail, studentPassword);
	} 
    @Path("getFacultyByPass/{facultyEmail}/{facultyPassword}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getFacultyByPass(@PathParam("facultyEmail") String facultyEmail,@PathParam("facultyPassword") String facultyPassword) {
		System.out.println("Recieved path params: "+facultyEmail+facultyPassword); 
		FacultyDAO facultyDAO = new FacultyDAO();
		return facultyDAO.getFacultyByPass(facultyEmail, facultyPassword);
	} 
    
    @Path("uploadImage")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadImage(@FormDataParam("bookImage") InputStream fileInputStream,@FormDataParam("bookImage") FormDataContentDisposition
	formDataContentDisposition, @FormDataParam("bookName") String bookName,@FormDataParam("bookAuthor") String bookAuthor, @FormDataParam("bookSubject") String bookSubject,@FormDataParam("bookPublishingYear") int bookPublishingYear,@FormDataParam("bookCount") int bookCount) throws IOException {; 
		int read = 0;
		byte[] bytes = new byte[1024];
		
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		String pathArr[] = path.split("/WEB-INF/classes/");
		
		FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition.getFileName()));
				
				
		while((read = fileInputStream.read(bytes)) != -1){	
			
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		
		BookDetails book = new BookDetails();
		book.setBookName(bookName);
		book.setBookImage(formDataContentDisposition.getFileName());
		book.setBookAuthor(bookAuthor);
		book.setBookSubject(bookSubject);
		book.setBookPublishingYear(bookPublishingYear);
		book.setBookCount(bookCount);
		BookDAO bookDao = new BookDAO();
		bookDao.additem(book);
	} 
    @Path("uploadPdf")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadPdf(@FormDataParam("thesisSubject") InputStream fileInputStream,@FormDataParam("thesisSubject") FormDataContentDisposition
	formDataContentDisposition, @FormDataParam("thesisName") String thesisName,@FormDataParam("thesisAuthor") String thesisAuthor,@FormDataParam("thesisPublishingYear") int thesisPublishingYear) throws IOException {; 
	int read = 0;
	byte[] bytes = new byte[3072];
	
	String path = this.getClass().getClassLoader().getResource("").getPath();
	
	String pathArr[] = path.split("/WEB-INF/classes/");
	System.out.println(pathArr[0]);
	FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition.getFileName()));
			
	while((read = fileInputStream.read(bytes)) != -1){	
		
		out.write(bytes,0,read);
	}
	
	out.flush();
	out.close();
		
		ThesisDetails book = new ThesisDetails();
		book.setThesisName(thesisName);
		book.setThesisSubject(formDataContentDisposition.getFileName());
		book.setThesisAuthor(thesisAuthor);
		book.setThesisPublishingYear(thesisPublishingYear);
		ThesisDAO bookDao = new ThesisDAO();
		bookDao.additem(book);
	} 
    @Path("getBooks")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookDetails> getBooks() {

    	BookDAO bookDAO = new BookDAO();
		
		List <BookDetails> bookList = bookDAO.getAllBookDetailsByImage();
		return bookList;
	}
    
    @Path("updateUser")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Object updateUser(StudentDetails editUser) {
		System.out.println("Data Recieved to Update : " + editUser);
		StudentDAO studentdao = new StudentDAO();
		return studentdao.update(editUser);
	}
    
    @Path("updateFaculty")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Object updateFaculty(FacultyDetails editUser) {
		System.out.println("Data Recieved to Update : " + editUser);
		FacultyDAO facultydao = new FacultyDAO();
		return facultydao.update(editUser);
	}
    
    @Path("getBookBySubject/{bookSubject}/{bookCount}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getBookBySubject(@PathParam("bookSubject") String bookSubject,@PathParam("bookCount") int bookCount) {
		System.out.println("Recieved path params: "+ bookSubject+bookCount); 
		BookDAO bookdao = new BookDAO();
		return bookdao.getBookBySubject(bookSubject,bookCount);
	} 
    @Path("studentBooking")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void studentBooking(BookingDetails booking) {
		System.out.println("Data Recieved in Booking Register : " + booking);
		BookingDAO bookingdao = new BookingDAO();
		bookingdao.register(booking);
	}
    @Path("getBookings")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookingDetails> getBookings() {

    	BookingDAO bookDAO = new BookingDAO();
		
		List <BookingDetails> bookList = bookDAO.getAllBookingDetails();
		return bookList;
	}
    @Path("getPdfs")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ThesisDetails> getPdfs() {

    	ThesisDAO bookDAO = new ThesisDAO();
		
		List <ThesisDetails> bookList = bookDAO.getAllPdfs();
		return bookList;
	}
    @Path("confirm/{name}/{userMail}/{Date}/{note}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String confirm(@PathParam("name") String name ,@PathParam("userMail") String userMail ,@PathParam("Date") String Date ,@PathParam("note") String note) throws MessagingException {
		String subject="Confirmation Mail";
		String body= "Dear"+" "+name+" "+";"+"Your Booking was"+note;
		String email= userMail;
		String host = "smtp.gmail.com";
		String from = "aparna8222@gmail.com";
		String pass = "nagendraV";

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true"); // added this line
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		String[] to = {email}; // added this line

		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));

		InternetAddress[] toAddress = new InternetAddress[to.length];

		// To get the array of addresses

		for( int i=0; i < to.length; i++ )
		{
			// changed from a while loop
			toAddress[i] = new InternetAddress(to[i]);
		}

		for( int i=0; i < toAddress.length; i++)
		{
			// changed from a while loop
			message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		}

		message.setSubject(subject);
		message.setText(body);

		Transport transport = session.getTransport("smtp");

		transport.connect(host, from, pass);
		transport.sendMessage(message, message.getAllRecipients());

		transport.close();
		System.out.println("Working");
        return "Successful";
    	}
    	@Path("updateRequest/{bookId}/{note}")
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public void updateRequest(@PathParam("bookId") int bookId,@PathParam("note") String note){
    		System.out.println("Data Recieved to Update : ");
    		HibernateTemplate.updateRequest(bookId,note);
    		System.out.println("Successfull Updation Request");
    	}	
    	@Path("delete/{bookId}")
    	@DELETE
    	@Produces(MediaType.APPLICATION_JSON)
    	public void cancel(@PathParam("bookId") int bookId){
    		System.out.println("Data Recieved in delete : " + bookId);
    		HibernateTemplate.cancel(bookId);
    		System.out.println("Successfull Deletion");
    	}
    	@Path("updateStatus/{bookId}/{bookCount}")
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public void updateStatus(@PathParam("bookId") int bookId,@PathParam("bookCount") int bookCount){
    		System.out.println("Data Recieved to Update : ");
    		HibernateTemplate.updateStatus(bookId,bookCount);
    		System.out.println("Successfull Updation Status");
    	}	
}
