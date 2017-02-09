/**
 * Reference-based implementation of ADT list.
 * Modify the code to implement a doubly linked list.
 *
 * @author
 */

import java.util.Iterator;

public class ListReferenceBased<E> implements ListInterface<E>, Iterable<E>{

    /** reference to the first element of the list */
    private Node<E> head; 
    /** number of items in list */
    private int numItems; 
    
    /** default constructor */
    public ListReferenceBased() {
	numItems = 0;
	head = null;
    }  // end default constructor
   
    /** Constructor that creates a list containing the specified element.
     * @param elt: element that is inserted in this new list.
    */
    public ListReferenceBased(E elt){
	numItems =0;
	append(elt);
    }

    /** copy constructor: create a new list that is a copy of the
     * specified list
     * @param lst: list copied
     */
    public ListReferenceBased(ListReferenceBased<E> lst){
	numItems=0;
	for (E item:lst)
	    append(item);
    }

     /** Tests if this list has no elements.
     * @return <code>true</code> if this list has no elements;
     * <code>false</code> otherwise.
     */

    public boolean isEmpty() {
	return numItems == 0;
    }  // end isEmpty
    
    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
     */

    public int size() {
	return numItems;
    }  // end size
    

    /** Locates a specified node in a linked list.
     * <li> Postcondition: 
     * @param index position of the desired node. Assumes that <code>
     * 1 <= index <= numItems+1</code>
     * @return a reference to the desired Node.
     */
    private Node<E> find(int index) {
	Node<E> curr = head;
	for (int skip = 1; skip < index; skip++) {
	    curr = curr.getNext();
	} // end for
	return curr;
    } // end find

    /** get the item location at the specified position in the list 
     * @param index position of the node containing the item
     * @return the Object located at the specified index
     * @throws ListIndexOutOfBoundsException if the index is out of
     * range, i.e. when <code> index <=0 || index > size() </code>
    */ 
    public E get(int index) 
	throws ListIndexOutOfBoundsException {
	if (index >= 1 && index <= numItems) {
	    // get reference to node, then data in node
	    Node<E> curr = find(index);
	    E dataItem = curr.getItem();
	    return dataItem;
	} 
	else {
	    throw new ListIndexOutOfBoundsException(
						    "List index out of bounds exception on get");
	} // end if
    } // end get
    
       
    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any)
     * and any subsequent elements to the right (adds one to their
     * indices).
     * @param index index at which the specified element is to be
     * inserted.
     * @param item element to be inserted.
     * @throws IndexOutOfBoundsException - if index is out of range
     * (index < 0 || index > size()).
     */
    public void add(int index, E item)
	throws ListIndexOutOfBoundsException {
	if (index >= 1 && index <= numItems+1) {
	    if (index == 1) {
		// insert the new node containing item at
		// beginning of list
		Node<E> newNode = new Node<E>(item, head);
		head = newNode;
	    } 
	    else{
		Node<E> prev = find(index-1);
		// insert the new node containing item after 
		// the node that prev references
		Node<E> newNode = new Node<E>(item, prev.getNext());
		prev.setNext(newNode);
		
	    } // end if
	    numItems++;
	} 
	else {
	    throw new ListIndexOutOfBoundsException(
						    "List index out of bounds exception on add");
	} // end if
    }  // end add
    

    /**
     * appends the specified element to the end of this list.
     * @param elt element to be added at the end of the list
     */
    public void append(E item)
    {
	add(numItems+1, item);
    }//end append
    

    /**
     * Removes the element at the specified position in this
     * list. Shifts any subsequent elements to the left (subtracts one
     * from their indices).
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException - if index is out of range
     * (index < 0 || index > size()).
     */
    public void remove(int index) 
	throws ListIndexOutOfBoundsException {
	if (index >= 1 && index <= numItems) {
	    if (index == 1) {
		// delete the first node from the list
		head = head.getNext();
	    } 
	    else{
		Node<E> prev = find(index-1);
		// delete the node after the node that prev
		// references, save reference to node
		Node<E> curr = prev.getNext(); 
		prev.setNext(curr.getNext());
	    } // end if
	    numItems--;
	} // end if
	else {
	    throw new ListIndexOutOfBoundsException(
						    "List index out of bounds exception on remove");
	} // end if
    }   // end remove
    
  
    /**
     * Remove all the elements in this list.
     */
    public void removeAll() {
	// setting head to null causes list to be
	// unreachable and thus marked for garbage 
	// collection
	head = null;
	numItems = 0;
    } // end removeAll
    


    /**
     * delete the the specified element in this list if exists,
     * otherwise state that the item is not in the current
     * list. Shifts any subsequent elements to the left (subtracts one
     * from their indices).
     * @param elt the element, if it exists, to delete
     */
    public void delete(E item){
	int index = contains(item);
	if (index == -1)
	    System.out.println("Try to delete " + item + " but it is not in the list");
	else
	    remove(index);
    }
    
    /**
     * Looks for the index of the specified element in this list. If
     * the element is not present, the method returns <code>-1</code>
     * @param elt the element which index is looked for.
     * @return either the index of the location in the list where the
     * argument is present or <code>-1</code> if the argument is not
     * contained in the list.
     */
    public int contains(E elt){
	Node<E> current = head;
	int index=1;
	while (index <= numItems && !current.getItem().equals(elt)){
	    index ++;
	    current = current.getNext();
	}
	if (index <= numItems)//  item found
	    return index;
	else
	    return -1;
    }
    
    /**
     * Prints all the elements in this list on the console in sequence
     */
    public void display(){
	for (E item: this)
	    System.out.print(item+" ");
	System.out.println();
    }

    public ListReferenceBasedIterator<E> iterator(){
	return  new ListReferenceBasedIterator<E>(head);
    }

} // end ListReferenceBased
