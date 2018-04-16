package pack;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class AddressBookManager
{
	
     private File file;
     private File[] listFile;
	 String adressbookname;
	 AddreeBook adrbook;
	 String path="/home/bridgeit/Documents/Gayatri/Addressbook/files/";
	
	
	public  void createNewAddressBook() throws JsonGenerationException, JsonMappingException, IOException {
		
		System.out.println("Give a name to your new address book:");
		String adressbookname1 = Utility.readString();
		file=new File(path + adressbookname1+".json");
		 try
		 {
		 if(file.createNewFile())
		 {
		 System.out.println(" Addressbook is created!");
		 }
		 else
		 {
		  System.out.println("Addressbook is already exist"); 
		 } 
		 }
		 catch (Exception e) {
			System.out.println("Exception occur while creating file");
		}
       }

	
	public void  openAddressBook() throws JsonParseException, JsonMappingException, IOException 
	{   
		boolean isExist=false;
//		file=new File(path);
//		listFile=file.listFiles();
		display();
		System.out.println("Enter name of address book to open:");
	    adressbookname= Utility.readString();
	    file=new File(path + adressbookname+".json");
	    for(int i=0; i< listFile.length; i++)
		{
		if(listFile[i].equals(file))
	     {
          adrbook = new AddreeBook(path +adressbookname+".json");
		  adrbook.operations();
		  isExist=true;
		  break;
		}
		}
		if(isExist==false)
		{
			System.out.println("Address Book is not exist");
		}	
	}	
		
	
	public  void saveAdressBook() throws JsonGenerationException, JsonMappingException, IOException
	{    
		 ObjectMapper mapper = new ObjectMapper();   
		 mapper.writeValue(new File(path +adressbookname+".json"),adrbook.getList());
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
