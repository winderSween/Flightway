/*
 * Created on Oct 13, 2004
 * @author class_sandip
 */
public class Destination{
    private String name;
    private double fare;
    
    public Destination(String cName,double airFare) {
	name = cName;
	fare = airFare;
    }  // end constructor
    public double getCost(){
	return fare;
    }
    public String getName(){
	return name;
    }
    public String toString() {
	return (getName()+ ", Cost: "+ fare);
    } // end toString
    public boolean equals(Object rhs){
	return((rhs instanceof Destination) && 
	       (name.compareTo(((Destination)rhs).getName())==0));
    }
}