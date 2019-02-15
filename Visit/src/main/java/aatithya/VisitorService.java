package aatithya;

import java.sql.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//service class where we can add and retrieve data from the table using post and get methods respectively

@RestController
@RequestMapping(value="/map", produces = "application/json")
public class VisitorService 
{
	VisitorDAO visitorDAO=new VisitorDAO();
	AdminDAO adminDAO=new AdminDAO();
	HostDAO hostDAO=new HostDAO();

	
	//to add data into Visitor table
	@RequestMapping(value="/visitoradd",method = RequestMethod.POST)

	public String showDetails(@RequestBody Visitor visitor)
	{
		String res=visitorDAO.addVisitorEntry(visitor,visitorDAO);
		return res;
	}
	
	
	
	//to display data present in Visitor table
	@RequestMapping(value="/visitorget",method=RequestMethod.GET)
	public ResponseEntity<List<Visitor>> getDetails()
	{
		List<Visitor> v=visitorDAO.getAllVisitors();
		return new ResponseEntity<List<Visitor>>(v,HttpStatus.OK);
	}
	
	
	//to add entries into Admin table
	@RequestMapping(value="/adminadd",method = RequestMethod.POST)

	public String showDetail(@RequestBody Admindetails admin)
	{
		String res=adminDAO.addAdminEntry(admin);
		return res;
	}
	
	
	//to validate a Admin entry credentials
	@RequestMapping(value="/admincheck",method=RequestMethod.POST,consumes="application/json")

	public String getLoginDetails(@RequestBody Admindetails admin)
	{

		return adminDAO.getLogin(admin);
	}
	
	
	
	//to display data present in Admin table
	@RequestMapping(value="/adminget",method=RequestMethod.GET)
	public ResponseEntity<List<Admindetails>> getAdminDetails()
	{
		List<Admindetails> v=adminDAO.getAdmindetails();
		return new ResponseEntity<List<Admindetails>>(v,HttpStatus.OK);
	}
	
	
	//to add hostname details to the table
    @RequestMapping(value="/hostadd" ,method=RequestMethod.POST,consumes="application/json")
    public String HostDetails(@RequestBody HostName hostname)
    {
			 
		String res=hostDAO.addHostName(hostname);
	    return res;
	        
	}
		
    //checks whether the host exists or not
	
    @RequestMapping(value="/hostcheck" ,method=RequestMethod.POST,consumes="application/json")
    public String showHostDetails(@RequestBody HostName hostname)
    {
			return hostDAO.getHostName(hostname);
	}
    
    //to display data present in hostname table
    @RequestMapping(value="/hostget",method=RequestMethod.GET)
	public ResponseEntity<List<HostName>> getDetail()
	{
		List<HostName> v=hostDAO.getHostName();
		return new ResponseEntity<List<HostName>>(v,HttpStatus.OK);
	}
    
    // checking visitor cheeckout
    @RequestMapping(value="/visitorcheckout",method=RequestMethod.POST,consumes="application/json")
    public String showCheckout(@RequestBody Visitor visitor)
    {  
        return visitorDAO.checkOut(visitor.getPhoneNumber());
                    
    }
    
    

}
