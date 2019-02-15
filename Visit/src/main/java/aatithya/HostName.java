package aatithya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HostName")
public class HostName 
{
	@Id
	@Column
    private String Id;
	
	@Column
	private String HostName;
	
	
	public HostName()
	{
		
	}

	public HostName(String id, String hostName) {
		super();
		Id = id;
		HostName = hostName;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getHostName() {
		return HostName;
	}

	public void setHostName(String hostName) {
		HostName = hostName;
	}
	
  
}
