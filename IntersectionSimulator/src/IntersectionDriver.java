import java.util.Scanner;

public class IntersectionDriver {
	
	private static Scanner sc = new Scanner(System.in);
	
	private int chance = 0;
	private int seconds = 0;

	public static void main(String[] args) {
		
		IntSim sim = new IntSim(0.25, 10);
		sim.Simulate();
		
		  int northSouthCars = sim.getTotalNSCars();

		  int eastWestCars = sim.getTotalEWCars();

		
		 System.out.println("Default intersection: ");

		 System.out.println("Each street has 25% chance to get a new car each second.");

		 System.out.println("Light changes from red to green every 10 seconds.");

		 System.out.println("Simulation length is 1000 seconds");
	
		 System.out.println("Cars across:\t" + northSouthCars + "\t" + eastWestCars);
		 
		 
		  System.out.print("\nEnter a new car creation chance (0.00 - 1.00): ");

		  double chance = sc.nextDouble();

		  System.out.print("\nEnter a new duration for traffic light (seconds): ");

		  int changeTime = sc.nextInt();

		  IntSim yourSimulator = new IntSim(chance, changeTime);

		  yourSimulator.Simulate();
	
		  northSouthCars = yourSimulator.getTotalNSCars();
		  eastWestCars = yourSimulator.getTotalEWCars();
		  
		  System.out.println("Cars across:\t" + northSouthCars + "\t" + eastWestCars);
	}

}
