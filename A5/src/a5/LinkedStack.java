package a5;

/**
 * A linked list-based implementation of the {@code Stack} interface.
 *
 * Isnt completely debugged
 */
public class LinkedStack implements Stack {
    // the number of elements currently on the stack
    private int size;
    
    // the node containing the top element of the stack
    private Node top;
    
    
    private static class Node {
            
        // the element stored in the node
        String elem;
    
        // the link to the next node in the sequence
        Node next;
    
        Node(String elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }
    
    
    /**
     * Initializes an empty stack.
     */
    public LinkedStack() {
    	this.size = 0;
    	this.top = null;
    }


	@Override
	public int size() {
		return this.size;
	}


	@Override
	public void push(String elem) {
		Node n = new Node(elem, this.top);
		this.top = n;
		this.size++;
	}


	@Override
	public String pop() {
		if (this.isEmpty()) {
			throw new RuntimeException("popped an empty stack");
		}
		String popped = this.top.elem;
		this.top = this.top.next;
		this.size--;
		return popped;
	}
	

    
	/**
     * Returns a string representation of this stack. The elements of the stack
     * appear in the returned string in sequence starting from the top of the
     * stack to the bottom of the stack with each element separated from the
     * next using a newline character.
     * 
     * @return a string representation of this stack
     */
	@Override
    public String toString() {
        StringBuilder b = new StringBuilder("LinkedStack:");
        Node n = this.top;
        while (n != null) {
            b.append('\n');
            b.append(n.elem);
            n = n.next;
        }
        return b.toString();
    }
	
	public LinkedStack(LinkedStack other) {
		other.size = size;
		other.top = top;
		
	}
	public void reverse() {
		int counter = 0;
		Node m = null;
		Node n = this.top;
		while(n != null) {
			Node next = n.next;
			n.next = m;
			m=n;
			n=next;
			this.push(m.elem);
		if (counter ==1) {
			this.pop();
		}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		LinkedStack t = new LinkedStack();
		t.push("A");
		t.push("B");
		t.push("C");
		System.out.println("size: " + t.size());
		System.out.println(t);
		System.out.println();
		
		String popped = t.pop();
		System.out.println("popped: " + popped);
		System.out.println("size: " + t.size());
		System.out.println(t);
		System.out.println();
		
		popped = t.pop();
		System.out.println("popped: " + popped);
		System.out.println("size: " + t.size());
		System.out.println(t);
		System.out.println();
		
		popped = t.pop();
		System.out.println("popped: " + popped);
		System.out.println("size: " + t.size());
		System.out.println(t);
		System.out.println();
		
	}
}
