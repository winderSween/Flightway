/*
 * Created on Oct 13, 2004
 * @author class_sandip
 */
public class City{
    private String name;
    private boolean visited;
    private int tryNext;
    private ListInterface<Destination> neighbors;
    
    public City(String cName) {
	name = cName;
	visited = false;
	tryNext = 0;
	neighbors = new ListReferenceBased<Destination>();
    }  // end constructor
    public void addNeighbor (Destination neighbor){
	neighbors.append(neighbor);
    }
    public String getNextCityName()throws IndexOutOfBoundsException {
	tryNext++;
	if (tryNext <= neighbors.size()){
	    return((Destination)neighbors.get(tryNext)).getName();
	}
	else
	    {
		throw new IndexOutOfBoundsException();
	    } // end if
    }
    public Destination findDest(String destName)
	throws IndexOutOfBoundsException {
	int index = neighbors.contains(new Destination(destName,0));
	if (index>0)
	    return (Destination)neighbors.get(index);
	else
	    throw new IndexOutOfBoundsException();
    }
    public boolean moreNeighbors(){
	return (tryNext < neighbors.size());
    }
    public void markVisited (){
	visited = true;
    }
    public void unmarkVisited (){
	visited = false;
    }
    public boolean isVisited(){
	return visited;
    }
    public void resetNext(){
	tryNext = 0;
    }
    public String getName(){
	return name;
    }
    public int getNext(){
	return tryNext;
    }
    public String toString() {
	return getName();
    } // end toString
    public boolean equals(Object rhs){
	return((rhs instanceof City) && 
	       (name.compareTo(((City)rhs).getName())==0));
    }
}