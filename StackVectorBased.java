/** Implementation of a Generic Stack using a Vector we consider the
 * top of the stack to be the first element in the Vector. Hence a
 * <code>push</code> adds an element in the front of the vector, and a
 * <code>pop</code> removes the first element of the vector.
 * @author St\'ephane
*/
import java.util.Vector;

public class StackVectorBased<E> implements StackInterface<E> {
    /** Vector used for the stack */
    private Vector<E> stack;
    
    /** default constructor */
    public StackVectorBased() {
	stack = new Vector<E>();
    }  // end default constructor
    

    /** Tests if this stack has no elements.
     * @return <code>true</code> if this list has no elements;
     * <code>false</code> otherwise.
     */
    public boolean isEmpty() {
	return stack.isEmpty();
    }  // end isEmpty
    

    /** Adds an item to the top of a stack.  	
     *Postcondition: If insertion is successful, newItem is on the top
     * of the stack
     * @param newItem is the item to be added.
     * @throws Some implementations may throw StackException when
     * newItem cannot be placed on the stack.
     */
    public void push(E newItem) throws StackException {
	stack.add(0, newItem);
    }  // end push
    
     /**
     * Removes all the items from the stack.
     * PostCondition: Stack is empty.
     */
    public void popAll() {
	stack.removeAllElements();
    }  // end popAll
    
    /**
     * Removes the top of a stack.
     * @return If the stack is not empty, the item that was added most
     * recently is removed from the stack and returned.
     * @throws StackException if the stack is empty.
     */
    public E pop() throws StackException {
	if (!isEmpty()) {
	    return stack.remove(0);
	}
	else {
	    throw new StackException("StackException on " +
				     "pop: stack empty");
	}  // end if
    }  // end pop
    
    /**  Retrieves the top of a stack.  
     * @return If the stack is not empty, the item that was added most
     * recently is returned. The stack is unchanged.
     * @throws StackException if the stack is empty.
     */
    public E peek() throws StackException {
	if (!isEmpty()) {
	    return stack.firstElement();
	}
	else {
	    throw new StackException("Stack exception on " +
				     "peek - stack empty");
	}  // end if
    }  // end peek
}  // end StackArrayBased
