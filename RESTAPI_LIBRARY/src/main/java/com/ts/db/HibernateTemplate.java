package com.ts.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tuple.entity.EntityTuplizerFactory;

import com.dto.FacultyDetails;
import com.dto.StudentDetails;



public class HibernateTemplate {

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj)
	{
		System.out.println("Inside Template...");
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		
		try {			
			return sessionFactory.openSession().get(c,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static Object getObjectByUserPass(String studentEmail,String studentPassword) {
	
	String queryString = "from StudentDetails where studentEmail = :studentEmail and studentPassword =:studentPassword";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setString("studentEmail", studentEmail);
	  query.setString("studentPassword", studentPassword);
	  Object queryResult = query.uniqueResult();
	  StudentDetails user = (StudentDetails)queryResult;
	  return user; 
	}
	
	
	public static Object getObjectByFacultyPass(String facultyEmail,String facultyPassword) {
		
		String queryString = "from FacultyDetails where facultyEmail = :facultyEmail and facultyPassword =:facultyPassword";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("facultyEmail", facultyEmail);
		  query.setString("facultyPassword", facultyPassword);
		  Object queryResult = query.uniqueResult();
		  FacultyDetails user = (FacultyDetails)queryResult;
		  return user; 
		}
	
	
	public static Object getObjectByEmail(String email) {
		
		String queryString = "from Employee where email = :email";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("email", email);
		  Object queryResult = query.uniqueResult();
		  StudentDetails user = (StudentDetails)queryResult;
		  return user;
		}
	
	
	public static List<Object> getObjectByBookImage()
	{
		String queryString = "from BookDetails";
		Query query = sessionFactory.openSession().createQuery(queryString);
		List result = query.list();
		return result;
		
	}
	
	public static List<Object> getObjectListVideo(String itemImage)
	{
		String queryString = "from ItemDetails c where ((:itemImage is null and c.itemImage is null) or c.itemImage = :itemImage)";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("itemImage", null);
		List result = query.list();
		return result;
	}
	public static List<Object> getImageByItemType(String itemType)
	{
		String queryString = "from ItemDetails c where ((:itemVideo is null and c.itemVideo is null) and c.itemType = :itemType) ";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("itemVideo", null);
		query.setString("itemType",itemType);
		List result = query.list();
		return result;
	}
	public static List<Object> getGardenerById(String email)
	{
		String queryString = "from CategoryDetails where email = :email";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("email", email);
		List result = query.list();
		return result;
	}
	public static List<Object> getAllFavourites(String itemEmail)
	{
		String queryString = "from FavouriteDetails where itemEmail = :itemEmail";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("itemEmail", itemEmail);
		List result = query.list();
		return result;
	}
	
	public static List<Object> getObjectListByQuery(String query)
	{
		return sessionFactory.openSession().createQuery(query).list();
	}
	public static void delete(int categoryId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sql = "delete FROM CategoryDetails WHERE categoryId = :categoryId";
        Query query = session.createQuery(sql);
        query.setInteger("categoryId", categoryId);
         int row = query.executeUpdate();
         if (row == 0)
             System.out.println("Doesnt deleted any row!");
         else
             System.out.println("Deleted Row: "+ row);
        session.getTransaction().commit();
        session.close();
    }
	public static void cancel(int itemId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sql = "delete FROM FavouriteDetails WHERE itemId = :itemId";
        Query query = session.createQuery(sql);
        query.setInteger("itemId", itemId);
         int row = query.executeUpdate();
         if (row == 0)
             System.out.println("Doesnt deleted any row!");
         else
             System.out.println("Deleted Row: "+ row);
        session.getTransaction().commit();
        session.close();
    }
	public static void updateRequest(int categoryId,String status){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sql = "update CategoryDetails c set c.status = :status where c.categoryId = :categoryId";
        Query query = session.createQuery(sql);
        query.setInteger("categoryId", categoryId);
        query.setString("status",status);
        int row = query.executeUpdate();
        System.out.println("Updated");
        session.getTransaction().commit();
        session.close();
    }
	public static void updateFavourite(int itemId,String favourite){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sql = "update ItemDetails c set c.favourite = :favourite where c.itemId = :itemId";
        Query query = session.createQuery(sql);
        query.setInteger("itemId", itemId);
        query.setString("favourite",favourite);
        int row = query.executeUpdate();
        System.out.println("Updated");
        session.getTransaction().commit();
        session.close();
    }
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		
		return result;
	}

	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	}
	
	
}
