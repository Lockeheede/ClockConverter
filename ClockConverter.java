import java.util.Scanner;

class ClockConverter {
	
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		char stop = ' ';
		
		int numHours = 0;
		int numMinutes = 0;
		int converted = 0;
		int leftOverMinutes = 0;
		
		while (stop != 's')
		{
		System.out.println("<--Welcome to Clock Converter-->");
		System.out.print("Enter number of hours : ");
		numHours = in.nextInt();
		System.out.print("Enter number of minutes : ");
		numMinutes = in.nextInt();
		
		converted = minutesToHours(numMinutes) + numHours;
		leftOverMinutes = minutesLeftOver(numMinutes);

		System.out.println();
		
		
		System.out.println("Total time : " + converted + ":" + leftOverMinutes);

		System.out.print("Stop program? Enter s for stop : ");
		stop = in.next().charAt(0);
		System.out.println(); //space between
		}
		
}
	public static int minutesToHours(int minutes)
	{
		int hours = minutes / 60;
		return hours;
	}
	
	public static int minutesLeftOver(int minutes)
	{
		int leftover = minutes % 60;
		return leftover;
	}
}