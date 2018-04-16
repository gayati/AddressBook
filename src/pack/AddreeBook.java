package pack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;


public class AddreeBook
{

	private String name;
	private String city;
	private String state;
	private int zipcode;
	private long phonenumber;
	private String filename;
	
	public AddreeBook(String filename)
	{
		this.filename = filename;
	}
	
	public  ArrayList<Person> list;
	//
	public  void operations() throws JsonGenerationException, JsonMappingException, IOException{
	  
		list = readMethod();
		int choice =0;
		do {	
		System.out.println("1.Add Person");
		System.out.println("2.Edit Person");
		System.out.println("3.Delete Person");
		System.out.println("4.Sort Details");
		System.out.println("5.Back");
		System.out.println("Plesae Enter your choice: ");
		 choice = Utility.readInteger();
		
		switch (choice) {
		case 1:addPerson(list);
			   break;
        case 2:editPerson();
			
			break;
        case 3:deletePerson();
			
			break;
        case 4:sortPersons();
		
		     break;
       
		default:
			break;
			
		}
		}while(choice<5);
	
	}
	
	
	public void addPerson(ArrayList<Person> list) throws JsonGenerationException, JsonMappingException, IOException
	{
		Address adress = new Address();
		Person person = new Person();
		
		System.out.println("Enter the name of person: ");
		name = Utility.readString();	
		person.setPersonname(name);
		
		System.out.println("Enter the city of person: ");
		city = Utility.readString();
	    adress.setCity(city);
	    
		System.out.println("Enter the state of person: ");
		state  =Utility.readString();
		adress.setState(state);
		
		System.out.println("Enter the zipcode");
	    zipcode = Utility.readInteger();
	    adress.setZipcode(zipcode);
	    
	    System.out.println("Enter the phonenumber: ");
	    phonenumber = Utility.readLong();
	    
	    String mobilepattern = "(0/91)?[7-9][0-9]{9}";
		    while(Pattern.matches(mobilepattern,String.valueOf(phonenumber))==false)
		    {
		    	System.out.println("Please enter proper mobile number: ");
		    	phonenumber = Utility.readLong();
		    }
	    person.setPhonenumber(phonenumber);	
	    person.setAdress(adress);
	    list.add(person);  
	    System.out.println(list);
	}
	
	public ArrayList<Person> getList()
	{
		return list;
	}
	
	
	
	public void editPerson()
	{
			System.out.println("Enter the name of person whose details you want to update:");
			name = Utility.readString();		
		    for(int i=0; i<list.size();i++)
		    {
		    	Person person = (Person)list.get(i);
		    
		      if(person.getPersonname().equals(name))
		      {
		    	  Address adress = person.getAdress();
					System.out.println(
							"select option what you want to edit:\n 1.City \n 3.State \n 3.Zip \n 4.MobileNumber \n 6.editAll");
					int choice = Utility.readInteger();
					switch (choice) {
					
					case 1:
						System.out.println("Enter the city you want to update");
						city = Utility.readString();
						adress.setCity(city);
						
						break;
					case 2:
						System.out.println("Enter the state you want to update");
					    state = Utility.readString();
					    adress.setState(state);
						break;
					case 3:
						System.out.println("Enter the zipcode you want to update");
						zipcode = Utility.readInteger();
					    adress.setZipcode(zipcode);
						break;
					case 4:
						System.out.println("Enter the mobilenumber you want to update");
						phonenumber = Utility.readLong();
				        person.setPhonenumber(phonenumber);
						break;
					default:
						System.out.println("Invalid Choice");

					}// switch
					person.setAdress(adress);
					break;
		      }
		      }
		              	   
			System.out.println(list);
	
}
	
	
	public void deletePerson()
	{
		System.out.println("Enter the first name of the person whose details you want to delete: ");
	    name = Utility.readString();
		
		boolean isExit = false;
		
		for(int i =0; i<list.size();i++)
		{
		 
			Person person = list.get(i);
		      if(person.getPersonname().equals(name))
		      {
		    	  list.remove(person);
                  System.out.println("Successfully Deleted...");
                  
				   isExit=true;
				   break;
			}
			}//for
		
		 System.out.println(list);
		
		if(isExit==false)
		{
			System.out.println("Person not found ");
		}
		}
	
	
	public void sortPersons()
	{
		class sortDetailsbyname implements Comparator<Object>
		{

			@Override
			public int compare(Object o1, Object o2) {
				
				Person person1 = (Person) o1;
				Person person2 = (Person) o2;
            
				return person1.getPersonname().compareTo(person2.getPersonname());
			}	
		}
			
			class sortDetailsbyzipcode implements Comparator<Object>
			{

				@Override
				public int compare(Object o1, Object o2) {
					
					Person p1 = (Person) o1;
					Address a1 = p1.getAdress();
					Person p2 = (Person) o2;
					Address a2 = p2.getAdress();
					
	            
					return (a1.getZipcode() -a2.getZipcode());
				}	
			}

			
	boolean check = true;
	do {
		System.out.println(
				"Sort according to \n 1.First Name \n 2.ZipCode  ");
		int choice = Utility.readInteger();
		switch (choice) {
		case 1:
			System.out.println("Sorting according to First Names: ");

			Collections.sort(list, new sortDetailsbyname());	
			
			Iterator<Person> nameIterator = list.iterator();

			while (nameIterator.hasNext())
			{
				Person person=  (Person) nameIterator.next();
				display(person);
			}
			break;
			
		case 2:
			System.out.println("Sorting according to Zip Code: ");

			Collections.sort(list, new sortDetailsbyzipcode());	 

			Iterator<Person> zipIterator = list.iterator();

			while (zipIterator.hasNext()) {
				Person person=  (Person) zipIterator.next();
				display(person);
			}
			break;
		}
		System.out.println("Press Y to continue and N to stop ");
		String ch = Utility.readString().toLowerCase();
		if (ch.equals("y")) {
			check = true;
		} else {
			check = false;
		}
	} while (check);
	}
	
	
	
	public ArrayList<Person> readMethod() throws IOException
	{
		 BufferedReader  reader = null;
		 String jsonArray = "";
			try {
				reader = new BufferedReader(new FileReader(filename ));
			} catch (FileNotFoundException e) {
				System.out.println("Adress book not exist");	
			}
			 jsonArray = reader.readLine();	 
	     if(jsonArray != null)
	     {
			 ObjectMapper objectMapper = new ObjectMapper();
	            
		  list= objectMapper.readValue(jsonArray, new TypeReference<ArrayList<Person>>(){});
	     }
	     else
	     {
	    	 System.out.println("Adressbook doesnot contain data");
	     }
		return list;			 
	}
	
   public void display(Person person)
   {
	   Address address = person.getAdress();
		System.out.println("\t************ ADDRESSBOOK ***************");
		System.out.println("\tFirst Name:\t" + person.getPersonname());
		
		 System.out.println("\tCity:\t\t" +address.getCity());
		 System.out.println("\tState:\t\t" + address.getState());
		 System.out.println("\tZipcode:\t" + address.getZipcode());
		 System.out.println("\tMobile number:\t" + person.getPhonenumber());
		
		 System.out.println("\t***********************************************");
		 System.out.println();
		 System.out.println();   
   }

}