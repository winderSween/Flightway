/**
 * Interface ListInterface for the ADT list.
 */

public interface ListInterface<E> {
    
    /** Tests if this list has no elements.
     * @return <code>true</code> if this list has no elements;
     * <code>false</code> otherwise.
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
    */
    public int size();
    
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
	throws ListIndexOutOfBoundsException,
	       ListException;

    
    /**
     * appends the specified element to the end of this list.
     * @param elt element to be added at the end of the list
     */
    public void append(E elt);

    /**
     * Returns the element at the specified position in this list.
     * @param index index of element to return.
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException - if index is out of range
     * (index < 0 || index > size()).
     */
    public E get(int index) 
	throws ListIndexOutOfBoundsException;
    
    /**
     * Removes the element at the specified position in this
     * list. Shifts any subsequent elements to the left (subtracts one
     * from their indices).
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException - if index is out of range
     * (index < 0 || index > size()).
     */

    public void remove(int index) 
	throws ListIndexOutOfBoundsException;
    
    /**
     * delete the the specified element in this list if exists. Shifts
     * any subsequent elements to the left (subtracts one from their
     * indices).
     * @param elt the element, if it exists, to delete
     */
    public void delete(E elt);

    /**
     * Remove all the elements in this list.
     */
    public void removeAll();

    /**
     * Looks for the index of the specified element in this list. If
     * the element is not present, the method returns <code>-1</code>
     * @param elt the element which index is looked for.
     * @return either the index of the location in the list where the
     * argument is present or <code>-1</code> if the argument is not
     * contained in the list.
     */
    public int contains(E elt);

    /**
     * Prints all the elements in this list on the console in sequence
     */
    public void display();

}  // end ListInterface
