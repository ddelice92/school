
public class Vehicle 
{
	private int vehNum;
	
	private int arrivalTime;
	
	private int departureTime;
	
	public Vehicle (int vehicleNum, int aTime, int dTime) 
	{
		vehNum = vehicleNum;

		arrivalTime = aTime;

		departureTime = dTime;
	}
	
	 public void setDepartureTime(int time)
	 {

		   departureTime = time;

	 }
	 
	 public int getVehicleNumber() 
	 {

		   return vehNum;

	 }
	 
	 public String toString() 
	 {

		   String waittime = String.format("%02d",(departureTime - arrivalTime));

		   return "[Time " + String.format("%02d", departureTime) + "] Vehicle #" + vehNum + " (" + ") " + ". Total wait time " + waittime + " seconds.";
	 }
	 
	 public int getWaitTime()
	 {
		 String waittime = String.format("%02d",(departureTime - arrivalTime));

		   return Integer.valueOf(waittime);
	 }
	 
}
