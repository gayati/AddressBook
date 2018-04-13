package pack;

import java.util.Scanner;

public class Utility 
{
static final Scanner SCANNER = new Scanner(System.in);	
	
	public static  int readInteger()
	{
		return SCANNER.nextInt();
	}
	public static String readString()
	{
		return SCANNER.next();
	}
	public static double readDouble()
	{
		return SCANNER.nextDouble();
		
	}
	public static long readLong()
	{
		return SCANNER.nextLong();
		
	}
	public static boolean readBoolean()
	{
		return SCANNER.nextBoolean();
		
	}
	public static char readChar()
	{
		return SCANNER.next().charAt(0);
		
	}

}
