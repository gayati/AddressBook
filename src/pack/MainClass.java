package pack;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public class MainClass {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		int choice=0;
		do {
		System.out.println("1.Create Address-Book");
		System.out.println("2.Open Address-Book");
		System.out.println("3.Save Address-Book");
		System.out.println("4.SaveAs Adress-Book");
		System.out.println("5.Close Address-Book");
		System.out.println("Enter your choice");
		choice = Utility.readInteger();
		AddressBookManager admgr = new AddressBookManager();
		switch (choice) {
		
		case 1:admgr.createNewAddressBook();		
			   break;
		case 2:admgr.openAddressBook();
		       break;
		case 3:admgr.saveAdressBook();
               break;
	    case 4:admgr.saveasAdressBook();
               break;
		case 5:System.exit(0);
	           break;
		default:System.out.println("Invalid Choice");
			   break;
		}
		
		}while(choice<6);
	}	
	
	

}
