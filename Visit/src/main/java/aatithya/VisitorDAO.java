package aatithya;

import java.sql.SQLData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.format.annotation.DateTimeFormat;

public class VisitorDAO
{
	private Configuration  configuration = new Configuration().configure("hibernate.cfg.xml");
	private SessionFactory sf=configuration.buildSessionFactory();
	private Session s;
	private Transaction tx;

   // to check whether the visitors are added to the visitor table or not
	public String addVisitorEntry(Visitor visitor,VisitorDAO visitorDAO ) 
	{
		try
		{
			s = sf.openSession();
			tx = s.beginTransaction();
			visitor.setCheckin(getInTime());
			visitor.setStatus("pending");
			visitor.setDate((java.sql.Date) getdate());
			//visitor.setCheckout(getoutTime());
			
			s.save(visitor);
			tx.commit();

		} catch (Exception e)
		{
			System.err.println("Exception : "+e.getMessage());
			tx.rollback();
		}
		finally
		{
			s.close();
		}
		return "added";

	}
	
	
	//to get the visitor entry time
	public String getInTime()
	{
		LocalTime currentTime=LocalTime.now(ZoneId.of("Asia/Kolkata"));
		DateTimeFormatter df=DateTimeFormatter.ISO_DATE_TIME;
		String time=currentTime.format(df);
		return time;
	}
	
	/*public String currentTime() throws ParseException
	{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();

        String frmtdDate = dateFormat.format(date);

        return frmtdDate;
    }*/
	
	
	
	public Date getdate()
	{
		//Date date = new Date();
		long time = System.currentTimeMillis();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
		return timestamp;
	}


	//to get visitor checkout time
	public String checkOut(long phone)
    {	
          try 
         {
            s = sf.openSession();
           tx = s.beginTransaction();
            Query query = s.createQuery("update Visitor set checkout ='"+getInTime()+"',status='completed'where phoneNumber= "+ phone +" AND checkout is null");
          
          query.executeUpdate();
         s.flush();
         tx.commit();
          }
          
        catch (Exception e)
        {
          System.err.println("Exception : " + e.getMessage());
          tx.rollback();
        }
        
         return "added";
	   
    }

	


	//to retrieve all visitors from visitor table 
	public List<Visitor> getAllVisitors()
	{
		s = sf.openSession();
		tx = s.beginTransaction();
		Query query=s.createQuery("from Visitor");
		List list=query.getResultList();
		tx.commit();
		s.close();
		return list;  
	}
    
	
}
