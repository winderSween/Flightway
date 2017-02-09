/**
 * @author huangshengwei
 * @ID 1475765
 */
import java.io.*;
import java.util.*;
/*
 * Created on Oct 13, 2004
 * @author class_sandip
 */
public class Map {
    private ListInterface<City> adjList;

    public Map(String mapFileName) {
	adjList = new ListReferenceBased<City>();
	createFlightMap(mapFileName);
    }
    public void createFlightMap(String mapFileName) {
	try {
	    Scanner input = new Scanner(new File(mapFileName));
	    Scanner line;
	    while (input.hasNextLine()){
		line = new Scanner(input.nextLine());
		String origCity = line.next();
		City ct = getCity(origCity);
		if (ct==null) {
		    ct = new City(origCity);
		    adjList.append(ct);
		}
		String destCity = line.next();
		if(getCity(destCity)==null)
		    adjList.append(new City(destCity));
		double cost = line.nextDouble();
		ct.addNeighbor(new Destination(destCity, cost));
	    }
	    input.close();
	} catch (IOException e) {
	    System.out.println("IOException in reading input file!!!");
	}
    }
    public void unvisitAll() {
	for (int i = 1; i <= adjList.size(); i++){
	    City ct =  adjList.get(i);
	    ct.unmarkVisited();
	    ct.resetNext();
	}	
    }

    // Use contains on adjList to return the City with name cityName
    // if it exists in the map, otherwise return null.
    public City getCity(String cityName) {
    	City getCity=new City(cityName);
    	int i=adjList.contains(getCity);
    	if(i>=0){
    		return adjList.get(i);
    	}
    	else{
    		return null;
    	}
	// NEED CODE FOR PROJECT
    }
 // If there are more neighbors to visit from ct,
 	// loop
 	//   get name of next neighbor 
 	//   retrieve the City with that name
 	//   if that City is unvisited return it
 	//
 	// if no unvisited neighbor of ct remains, return null
    public City getNextCity(City ct) {
    	while(ct.moreNeighbors()){
    		String neighborsname=ct.getNextCityName();
    		for(int i=1;i<=adjList.size();i++){
    			if(adjList.get(i).equals(neighborsname)&&adjList.get(i).isVisited()==false){
    				return adjList.get(i);
    			}
    		}
    	}	
		return null;
	// NEED CODE FOR PROJECT
    }
    public void findPath(String origin, String destination) {
	//	   ---------------------------------------------------
	//	   Determines whether a sequence of flights between
	//	   two cities exists. Nonrecursive stack version.
	//	   Precondition: origin and destination are the origin
	//	   and destination city names, respectively.
	//	   Postcondition: Prints out a sequence of flights
	//	   connecting origin to destination and the total
	//	   cost, otherwise prints out a failure
	//	   message. Cities visited during search are marked as
	//	   visited in the flight map.  Implementation notes:
	//	   Uses a stack for the cities of a potential
	//	   path. Calls unvisitAll, markVisited, and
	//	   getNextCity.
	//	   ---------------------------------------------------

	City originCity = getCity(origin);
	if (originCity == null)
	    System.out.println("No flights from " + origin);
	else {
	    City destinationCity = new City(destination);
	    StackInterface<City> stack = new StackVectorBased<City>();
	    unvisitAll();
	    stack.push(originCity);
	    while(!(stack.isEmpty())){
	    	City nextCity = getNextCity(stack.peek());
	    	
	    	if(nextCity != null){
			    nextCity.markVisited();
			    stack.push(nextCity);
			 	if(stack.peek().equals(destinationCity)){
			 		StackInterface<City> outputStack = new StackVectorBased<City>();
			 		double totalCost = 0;
			 		while (!(stack.isEmpty())){
			 				stack.pop();
			 				outputStack.push(stack.pop());
			 				if (!stack.pop().getName().equals(originCity.getName())){	
			 					Destination dest=stack.peek().findDest(stack.pop().getName());
			 					totalCost+=dest.getCost();
			 				} 	
			 		}	
			 		while (!(outputStack.isEmpty())){
			 			System.out.print(outputStack.pop().getName());			 			
			 		}
			    	System.out.println("total cost is "+totalCost);
			    	return;										
			    }
			 // NEED CODE FOR PROJECT 
			    // Use stack to search the map and if path is found,
			    // print out the path and the total cost
		    }else{
		    	stack.pop();
		    	continue;
		    }
		    
	    }
	    System.out.println("There are no flights from "+ origin+" to "+ destination);
	}
    } // end isPath
}
