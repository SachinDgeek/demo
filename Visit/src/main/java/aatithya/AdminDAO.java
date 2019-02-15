package aatithya;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class AdminDAO 
{
	private Configuration  configuration = new Configuration().configure("hibernate.cfg.xml");
	private SessionFactory sf=configuration.buildSessionFactory();
	private Session s;
	private Transaction tx;


	public String addAdminEntry(Admindetails admin ) 
	{
		try
		{
			s = sf.openSession();
			tx = s.beginTransaction();
			s.save(admin);
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
	public List<Admindetails> getAdmindetails()
	{
		s = sf.openSession();
		tx = s.beginTransaction();
		Query query=s.createQuery("from Admindetails");
		List list=query.getResultList();
		tx.commit();
		s.close();
		return list;  
	}


	public String getLogin(Admindetails login)
	{

		s = sf.openSession();
		tx = s.beginTransaction();
		NativeQuery<?> query= s.createNativeQuery("select 1 from Admindetails where Username='"+login.getUname()+"' and Password = '"+login.getPassword()+"'");
		if(query.uniqueResult()!=null)
		{
			return "success";
		}
		else 
		{
			return "failure";
		}

	}
}
