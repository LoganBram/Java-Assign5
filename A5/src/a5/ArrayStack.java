package a5;

import java.util.Arrays;

/**
 * An array-based implementation of the {@code Stack} interface.
 *
 */
public class ArrayStack implements Stack {

    // the initial capacity of the stack
    private static final int DEFAULT_CAPACITY = 16;

    // the array that stores the stack
    private String[] arr;

    // the index of the top of the stack (equal to -1 for an empty stack)
    private int top;

    /**
     * Initialize an empty stack.
     */
    public ArrayStack() {
        this.arr = new String[ArrayStack.DEFAULT_CAPACITY];
        this.top = -1;
    }
    
    @Override
    public int size() {
        return this.top + 1;
    }

    @Override
    public void push(String elem) {
    	// do we need to resize the array?
        if (this.size() == this.arr.length) {
            this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }
        this.top++;
        this.arr[this.top] = elem;    // will throw an exception if this.top == this.arr.length
    }

    @Override
    public String pop() {
        // is the stack empty?
        if (this.isEmpty()) {
            throw new RuntimeException("popped an empty stack");
        }
        // get the element at the top of the stack as type E
        String element = this.arr[this.top];
        
        // null out the value stored in the array so that we don't keep a reference to the string
        this.arr[this.top] = null;

        // adjust the top of stack index
        this.top--;

        // return the element that was on the top of the stack
        return element;
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
        StringBuilder b = new StringBuilder("ArrayStack:");
        if (this.size() != 0) {
            for (int i = this.size() - 1; i >= 0; i--) {
                b.append('\n');
                b.append(this.arr[i]);
            }
        }
        return b.toString();
    }
    
    public ArrayStack(ArrayStack other) {
    	this.arr = other.arr;
    	this.top = other.top;
    }
    
    public ArrayStack(Stack other) {
    	
    	ArrayStack copystack1 = new ArrayStack();
    	Stack product1 = new ArrayStack();
    	for (int i = 0; i-3 < other.size();i++) {
    		String cop = other.pop();
    		copystack1.push(cop);	
    	}
    	
    	for (int t = 0; t-3 < copystack1.size();t++) {
    		System.out.println(copystack1+"as");
    		String cop2 = copystack1.pop();
    		other.push(cop2);
    		product1.push(cop2);
    	}
    	
    	System.out.println(other+"original");
    	System.out.println(product1+"copy");
    }
    
    public void reverse() {
    	int start = 0;
    	int end =  this.top + 1;
    	while (start < end) {
    		String temp = this.arr[start];
    		this.arr[start] = this.arr[end];
    		this.arr[end] = temp;
    		start = start + 1;
    		end = end-1;	
    	}
    }
    
    
    
    
	public static void main(String[] args) {
		ArrayStack t = new ArrayStack();
		t.push("A");
		t.push("B");
		t.push("C");
		System.out.println("size: " + t.size());
		System.out.println(t);
		
		
	
	
		
		System.out.println("");
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