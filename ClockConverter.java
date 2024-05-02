import java.util.Scanner;

class ClockConverter {
	
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		char stop = ' ';
		char hourStop = ' ';
		char minStop = ' ';
		char secStop = ' ';
		
		int numHours = 0;
		int numMinutes = 0;
		int numSeconds = 0;
		int converted = 0;
		int leftOverMinutes = 0;
		int leftOverSeconds = 0;
		
		while (stop != 's')
		{
		hourStop = ' ';
		minStop = ' ';
		secStop = ' ';
		System.out.println("<--Welcome to Clock Converter-->");
		while (hourStop != 's')
		{
			System.out.print("Enter number of hours : ");
			numHours += in.nextInt();
			System.out.print("Enter 's' to stop entering hours : ");
			hourStop = in.next().charAt(0);
		}
		while (minStop != 's')
		{
			System.out.print("Enter number of minutes : ");
			numMinutes += in.nextInt();
		
			System.out.print("Enter 's' to stop entering minutes : ");
			minStop = in.next().charAt(0);
		}
		while (secStop != 's')
		{
			System.out.print("Enter number of seconds : ");
			numSeconds += in.nextInt();
		
			System.out.print("Enter 's' to stop entering seconds : ");
			secStop = in.next().charAt(0);
		}
		
		numMinutes += secondsToMinutes(numSeconds);
		leftOverSeconds = secondsLeftOver(numSeconds);
		converted = minutesToHours(numMinutes) + numHours;
		leftOverMinutes = minutesLeftOver(numMinutes);

		System.out.println();
		
		
		System.out.printf("Total time : %d:%02d:%02d%n", converted, leftOverMinutes, leftOverSeconds);

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
	
	public static int secondsToMinutes(int seconds)
	{
		int minutes = seconds / 60;
		return minutes;
	}
	
	public static int secondsLeftOver(int seconds)
	{
		int leftover = seconds % 60;
		return leftover;
	}
}