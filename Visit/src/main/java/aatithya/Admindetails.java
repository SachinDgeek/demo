package aatithya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name ="Admindetails")
public class Admindetails 
{



	@Id
	@Column(name="Username")
	private String uname;

	@Column(name="Password")
	private String password;

	public Admindetails(String uname, String password)
	{

		this.uname = uname;
		this.password = password;
	}

	public Admindetails()
	{

	}




	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
