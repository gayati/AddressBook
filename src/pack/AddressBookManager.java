package pack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class AddressBookManager
{
	
     private File file;
     private File[] listFile;
	 static String adressbookname;
	 AddreeBook adrbook;
	 String path="/home/bridgeit/Documents/Gayatri/Addressbook/files/";
	
	static ArrayList<Person> list2 ;
	
	public  void createNewAddressBook() throws JsonGenerationException, JsonMappingException, IOException {
		
		display();
		System.out.println("Give a name to your new address book:");
		String adressbookname1 = Utility.readString();
		file=new File(path + adressbookname1+".json");
		
		try {
			for(int i=0; i< listFile.length; i++)
			{
				
			
				 if(listFile[i].equals(file))
				 {
					 System.out.println("The file with same name is already exist,enter newname");
					 String adressbookname2 = Utility.readString();
					// file.createNewFile();
					 File file1=new File(path+adressbookname2+".json");
					 try
					 {
					 if(file1.createNewFile())
					 {
					 System.out.println("Address book is created!");
					 break;
					 }
					 }
					 catch (Exception e) {
						System.out.println("Exception occur while creating file");
					}
				 }}
			 	  
			 } catch (Exception e) {
				e.printStackTrace();
				}
			 
			 }
	
	public void  openAddressBook() throws JsonParseException, JsonMappingException, IOException 
	{
		display();
		System.out.println("Enter name of address book to open:");
	    adressbookname= Utility.readString();
		if (listFile.length>0) 
		{
          adrbook = new AddreeBook(path +adressbookname+".json");
		  list2= adrbook.readMethod();
          System.out.println(list2);
		  adrbook.operations();
		}
		else
		{
			System.out.println("Address Book is not exist");
		}
	}	
		
	
	public  void saveAdressBook() throws JsonGenerationException, JsonMappingException, IOException
	{ 
		 ObjectMapper mapper = new ObjectMapper();   
		 mapper.writeValue(new File(path +adressbookname+".json"),list2);
		 System.out.println("Address book details are saved successfully.....");
	}
	
	
	public  void saveasAdressBook() throws JsonGenerationException, JsonMappingException, IOException
	{      
		  display();
		  System.out.println("Enter the name of existing filename to replace: ");
		  String existingname = Utility.readString();
		  file = new File(path +existingname+".json");
		  
		  System.out.println("Enter the filename to replace ");
		  String newname = Utility.readString().trim();
		  
		  System.out.println("Enter the extention to replace ");
		  String newextention = Utility.readString().trim();
		  
	      File tmpFile = new File(path +newname+newextention);
        
		if (file.renameTo(tmpFile))
		{
			  System.out.println("Success");  
		}	
	}
	
	public void display()
	{
		 file=new File(path);
		 listFile=file.listFiles();
		System.out.println("list of addresbooks in folder: ");
		for(File file1: listFile)
		{
			System.out.println(file1.getName());
		}
	}
}
