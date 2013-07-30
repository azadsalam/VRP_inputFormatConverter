import java.io.PrintWriter;


public class TargetFormat 
{
	
	int testCase=1;
	int periodCount;
	int depotCount;
	int totalVehicle;
	int vehiclePerDepot[];
	double capacity[];
	double timeConstraint[][];
	int clientCount;
	int frequency[];
	double serviceTime[];
	double demand[];
	double costMatrix[][];


	PrintWriter out;
	public TargetFormat(PrintWriter out) 
	{
		// TODO Auto-generated constructor stub
		this.out = out;
	}
	
	public void print() 
	{
		out.print(testCase);
		out.println(" ; number of test cases ; for now it is ignored");
		
		out.print(periodCount);
		out.println(" ; number of periods");
		
		out.print(depotCount);
		out.println(" ; number of depots");
		


		
		for(int i=0;i<depotCount;i++)
		{
			out.print(vehiclePerDepot[i]+" ");
		}
		out.println(" ; number of vehicle per depot");
		
		for(int i=0;i<totalVehicle;i++)
		{
			out.print(capacity[i]+" ");
		}
		out.println(" ; Maximum allowable load of each vehicle");
		
		out.println("; t(total period) lines containg  v (total vehicle) values each referring maximum time limit (route duration) for that day for that vehicle (NEW)");
		
		for(int i=0;i<periodCount;i++)
		{
			for(int j=0;j<totalVehicle;j++)
			{
				out.print(timeConstraint[i][j] + " ");
			}
			out.println("");
		}

		
		out.print(clientCount);
		out.println(" ; number of clients");
		
		for(int i=0;i<clientCount;i++)	out.print(frequency[i]+" ");		
		out.println(" ; frequency");

		for(int i=0;i<clientCount;i++)	out.print(serviceTime[i]+" ");		
		out.println(" ; service time for every client");

		for(int i=0;i<clientCount;i++)	out.print(demand[i]+" ");		
		out.println(" ; demand for every client ");

		out.println("; COST MATRIX");
		
		
		for(int i=0;i<depotCount+clientCount;i++)
		{
			for(int j=0;j<depotCount+clientCount;j++)
			{
				out.print(costMatrix[i][j]+" ");
			}
			out.println("");
		}

		
		out.close();
	}

}
