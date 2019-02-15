package aatithya;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class HostDAO 
{
	private Configuration  configuration = new Configuration().configure("hibernate.cfg.xml");
	private SessionFactory sf=configuration.buildSessionFactory();
	private Session s;
	private Transaction tx;


	public String addHostName(HostName host ) 
	{
		try
		{	
			s = sf.openSession();
			tx = s.beginTransaction();
			s.save(host);
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
	public List<HostName> getHostName()
	{
		s = sf.openSession();
		tx = s.beginTransaction();
		Query query=s.createQuery("from HostName");
		List list=query.getResultList();
		tx.commit();
		s.close();
		return list;  
	}


	public String getHostName(HostName host)
	{

		s = sf.openSession();
		tx = s.beginTransaction();
		NativeQuery<?> query= s.createNativeQuery("select 1 from HostName where hostName='"+host.getHostName()+"' and id = '"+host.getId()+"'");
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
