import java.util.Iterator;
    public class ListReferenceBasedIterator<E> implements Iterator<E>{
	Node<E> current;

	public ListReferenceBasedIterator(Node<E> node){
	    current=node;
	}
	
	public boolean hasNext(){
	    return (current!=null);
	}

	public E next(){
	    E elt = current.getItem();
	    current = current.getNext();
	    return elt;
	}

	public void remove(){}
    }
