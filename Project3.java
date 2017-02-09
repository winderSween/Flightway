import java.io.*;
import java.util.*;

/*
 * Created on Oct 14, 2004
 * @author sandip
 */
public class Project3{
    public static void main(String args[]) {
	try {
	    String inputLine; //stores each line from the file
	    Scanner scanLine;
	    Map flightMap = new Map("flights.dat");
	    Scanner input = new Scanner(new File("flightQueries.dat"));
	    while (input.hasNextLine()){
		scanLine = new Scanner(input.nextLine());
		flightMap.findPath(scanLine.next(),scanLine.next());
	    }
	    input.close();
	} 
	catch (IOException e) {
	    System.out.println("IOException in reading input file!!!"+e);
	}	
    }
}