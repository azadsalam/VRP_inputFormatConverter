import java.util.Scanner;

/*



*/
public class CordeauMDVRP 
{
	
	Scanner in;
	int vehicleCount,customerCount,depotCount;
	double routeDurationConstraint[],capacity[];
	double x[],y[],serviceDuration[],demand[];
	int frequency[];
	
	TargetFormat target;
	 public CordeauMDVRP(Scanner in,TargetFormat target) {
		// TODO Auto-generated constructor stub
		 this.in = in;
		 this.target = target;
	}
	
	 //read from file  in variables
	public void prepare() 
	{	
		in.nextInt(); // skip type
		vehicleCount = in.nextInt();
		customerCount = in.nextInt();
		depotCount = in.nextInt();
		
		routeDurationConstraint = new double[depotCount];
		capacity = new double[depotCount];
		for(int i=0;i<depotCount;i++)
		{
			routeDurationConstraint[i] = in.nextDouble();
			capacity[i] = in.nextDouble();
		}

		
		x = new double[customerCount+depotCount];
		y = new double[customerCount+depotCount];
		serviceDuration = new double[customerCount];
		demand = new double[customerCount];
		frequency = new int[customerCount];
		for(int i=0;i<customerCount;i++)
		{
			in.nextInt();
			x[depotCount+i] = in.nextDouble();
			y[depotCount+i] = in.nextDouble();
			serviceDuration[i] = in.nextDouble();
			demand[i] = in.nextDouble();
			frequency[i] = in.nextInt();
			in.nextLine();
		}
		
		for(int i=0;i<depotCount;i++)
		{
			in.nextInt();
			x[i] = in.nextDouble();
			y[i] = in.nextDouble();
			in.nextLine();

		}
	}
	
	// initialise the target variable with data
	public void do_transaction() 
	{
		target.periodCount = 1; // it is MDVRP , so no P =1;
		target.depotCount = depotCount;
		target.totalVehicle = vehicleCount*depotCount;
		
		target.vehiclePerDepot = new int[depotCount];
		for(int i=0;i<depotCount;i++)
			target.vehiclePerDepot[i]=vehicleCount;
		
		target.capacity = new double[target.totalVehicle];
		int count=0;
		for(int i=0;i<depotCount;i++)
		{
			for(int j=0;j<vehicleCount;j++)
			{
				target.capacity[count++] = capacity[i];
			}
		}
		
		
		target.timeConstraint = new double[1][target.totalVehicle];
		
		count=0;
		for(int i=0;i<depotCount;i++)
		{
			for(int j=0;j<vehicleCount;j++)
			{
				target.timeConstraint[0][count++] = routeDurationConstraint[i];
			}
		}
			
		
		target.clientCount = customerCount;
		target.frequency = frequency;
		target.serviceTime = serviceDuration;
		target.demand = demand;
		
		
		target.costMatrix = new double[depotCount+customerCount][depotCount+customerCount];
		
		for(int i=0;i<depotCount+customerCount;i++)
		{
			for(int j=0;j<depotCount+customerCount;j++)
			{
				target.costMatrix[i][j] = distance(x[i], y[i], x[j], y[j]);
			}
		}
		
	}
	
	public double distance(double x1, double y1, double x2, double y2) 
	{
		double res = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2); 
		res = Math.sqrt(res);
		return res;	
	}
	
}
