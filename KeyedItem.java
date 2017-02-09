/*
 * Created on Oct 13, 2004
 */

/**
 * @author class_sandip
 *
 */

public abstract class KeyedItem {
    private Comparable searchKey;
    
    public KeyedItem(Comparable key) {
	searchKey = key;
    }  // end constructor
    
    public Comparable getKey() {
	return searchKey;
    } // end getKey

}