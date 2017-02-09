/** Generic Stack Interface */
public interface StackInterface<E> {

    /** Determines whether the stack is empty.
     * @return true if the stack is empty; false otherwise
     */
    public boolean isEmpty();
    
    /**
     * Removes all the items from the stack.
     * PostCondition: Stack is empty.
     */
    public void popAll();
    
    /** Adds an item to the top of a stack.  	
     *Postcondition: If insertion is successful, newItem is on the top
     * of the stack
     * @param newItem is the item to be added.
     * @throws Some implementations may throw StackException when
     * newItem cannot be placed on the stack.
     */
    public void push(E newItem) throws StackException;

    /**
     * Removes the top of a stack.
     * @return If the stack is not empty, the item that was added most
     * recently is removed from the stack and returned.
     * @throws StackException if the stack is empty.
     */
    public E pop() throws StackException;
  
  
    /**  Retrieves the top of a stack.  
     * @return If the stack is not empty, the item that was added most
     * recently is returned. The stack is unchanged.
     * @throws StackException if the stack is empty.
     */
    public E peek() throws StackException;
 
    

}  // end StackInterface
