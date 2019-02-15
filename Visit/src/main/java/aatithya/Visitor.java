package aatithya;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeContext;

@Entity
@Table(name="Visitor")
public class Visitor
{
	@Id
	@Column(name="Phone_Number")
	private long phoneNumber;
	
	@Column(name="Visitor_Name")
	private String name;
	
	@Column(name="Date")
	private Date date;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Purpose")
	private String purpose;
	
		


	@Column(name="Host_Name")
	private String hostName;
	
	@Column(name="checkin")
	private String checkin;
	
	@Column(name="checkout")
	private String checkout;
	
	@Column(name="status")
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public Visitor(long phoneNumber, String name, Date date, String email, String purpose, String hostName,
			String checkin, String checkout, String status) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.date = date;
		this.email = email;
		this.purpose = purpose;
		this.hostName = hostName;
		this.checkin = checkin;
		this.checkout = checkout;
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Visitor(){

	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPurpose() {
		return purpose;
	}
	public String getHostName() {
		return hostName;
	}
}
