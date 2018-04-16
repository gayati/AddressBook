package pack;

import java.util.Scanner;

public class Utility 
{
 static  Scanner scanner = new Scanner(System.in);	
	
	public static  int readInteger()
	{
		
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			scanner.nextLine();
			System.out.println("Enter proper input, try again");
			return readInteger();
		}
	}
	public static String readString()
	{
		return scanner.next();
	}
	public static double readDouble()
	{
		try {
			return scanner.nextDouble();
		} catch (Exception e) {
			scanner.nextLine();
			System.out.println("Enter proper input, try again");
			return readDouble();
		}
		
	}
	public static long readLong()
	{  
		try {
			return scanner.nextLong();
		} catch (Exception e) {
			scanner.nextLine();
			System.out.println("Enter proper input, try again");
			return readLong();
		}
		
		
	}
	public static boolean readBoolean()
	{
		return scanner.nextBoolean();
		
	}
	public static char readChar()
	{
		return scanner.next().charAt(0);
		
	}

}
