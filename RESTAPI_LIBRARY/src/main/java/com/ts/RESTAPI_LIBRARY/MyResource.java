package com.ts.RESTAPI_LIBRARY;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.Consumes;
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
import com.dao.FacultyDAO;
import com.dao.StudentDAO;
import com.dto.BookDetails;
import com.dto.FacultyDetails;
import com.dto.StudentDetails;

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
	formDataContentDisposition, @FormDataParam("bookName") String bookName,@FormDataParam("bookAuthor") String bookAuthor, @FormDataParam("bookSubject") String bookSubject,@FormDataParam("bookPublishingYear") int bookPublishingYear) throws IOException {; 
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
		//book.setBookStatus(bookStatus);
		BookDAO bookDao = new BookDAO();
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
    
}
