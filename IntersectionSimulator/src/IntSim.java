import java.lang.Math;
import java.io.*;
import java.util.*;
import java.net.*;

public class IntSim 
//construct each queue for each direction of travel
{
	private LinkedQueue<Vehicle> EW = new LinkedQueue<Vehicle>();
	private LinkedQueue<Vehicle> WE = new LinkedQueue<Vehicle>();
	private LinkedQueue<Vehicle> NS = new LinkedQueue<Vehicle>();
	private LinkedQueue<Vehicle> SN = new LinkedQueue<Vehicle>();
	
	int time = 0;
	int i = 0;
	int vehNum = 1;
	FileWriter fw;
	BufferedWriter bw;
	PrintWriter outFile;
	double chance = 0.0;
	int lightChangeTime = 0;
	
	 public IntSim(double chance, int lightChangeTime) 
	 {
		 this.chance = chance;
		 this.lightChangeTime = lightChangeTime;
		 
	 }

	 public void Simulate() {
	       try 
	       {
	       fw = new FileWriter("output.txt");
	       bw = new BufferedWriter(fw);
	       outFile = new PrintWriter(bw);
	       int randomNumber;
	       outFile.print("---Start of simulation, time set to 0.--- \n");
	       randomNumber = carProbability(chance);
	       populate(randomNumber);
	       while(time<=1000) {
	       outFile.print("---Light changed. Now processing north/south-bound traffic--- \n");
	       moveNS();
	       randomNumber = carProbability(chance);
	       populate(randomNumber);
	       outFile.println();
	       outFile.print("---Light changed. Now processing east/west-bound traffic---\n");
	       moveEW();
	       randomNumber = carProbability(chance);
	       populate(randomNumber);
	       outFile.println();
	       }
	       outFile.close();
	       }
	  
	 
   catch (IOException e)
	  {
       System.err.println("Error printing to file");
      }      
}

private void populate (int randomNum) 
{
	int count = 0;
	while (count < randomNum && time <= 1000)
	{
		Vehicle car = new Vehicle(vehNum, time, time);
		count++;
		vehNum++;
	}
}

private void moveNS() 
{
	int i = 0;
	while (i<2) 
	{
		time += lightChangeTime;
		try 
		{ 
			if (!NS.isEmpty()) {
				Vehicle car = new Vehicle(0,0,0);
				car = NS.dequeue();
				car.setDepartureTime(time);
				car.getWaitTime();
				outFile.println(car);
				}
			
		}
		catch(EmptyCollectionException e) {}
        try 
        {  
            if (!SN.isEmpty()) 
            {
                Vehicle car = new Vehicle(0,0,0);
                car = SN.dequeue();
                car.setDepartureTime(time);
                car.getWaitTime();
                outFile.println(car);                  
            }
        }
        catch(EmptyCollectionException e) {}
        i++;
	}
}

private void moveEW() 
{
	int i = 0;
	while (i<2) 
	{
		time += lightChangeTime;
		try 
		{ 
			if (!EW.isEmpty()) {
				Vehicle car = new Vehicle(0,0,0);
				car = NS.dequeue();
				car.setDepartureTime(time);
				car.getWaitTime();
				outFile.println(car);
				}
			
		}
		catch(EmptyCollectionException e) {}
        try 
        {  
            if (!WE.isEmpty()) 
            {
                Vehicle car = new Vehicle(0,0,0);
                car = SN.dequeue();
                car.setDepartureTime(time);
                car.getWaitTime();
                outFile.println(car);                  
            }
        }
        catch(EmptyCollectionException e) {}
        i++;
	}
}

private boolean queuesEmpty() 
{
	boolean empty;
	
		empty = NS.isEmpty();
	
	if (empty)
		empty = SN.isEmpty();
	if (empty)
		empty = EW.isEmpty();
	if (empty)
		empty = WE.isEmpty();
	return empty;
}

private int carProbability(double chance)
{
   return (int)(chance*10*Math.random() * (11 - 1) + 1);
}

public int getTotalNSCars()
{
   int totalNSCars = 0;
	return totalNSCars;
}

public int getTotalEWCars()
{
	int totalEWCars = 0;
	return totalEWCars;
}
}