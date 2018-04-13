package pack;

public class Person
{
	
	private String personname;
	private long phonenumber;
	
	Address adress;
	
	@Override
	public String toString() {
		return "Person [personname=" + personname + ", phonenumber=" + phonenumber + ", adress=" + adress + "]";
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	


}
