import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;



public class Main {

	public static Scanner in;
	public static PrintWriter out;
	
	public static File inputFile,outputFile;
	
	public static String inputFileName = "in.txt";
	public static String outputFileName = "out.txt";
	
	public static TargetFormat target;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		inputFile = new File(inputFileName);
		outputFile = new File(outputFileName);
		
		try 
		{
			in = new Scanner(inputFile);
			out = new PrintWriter(outputFile);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		target = new TargetFormat(out);
		
		
		CordeauMDVRP converter = new CordeauMDVRP(in,target);
		
		converter.prepare();
		converter.do_transaction();
		
		target.print();
	}

}
