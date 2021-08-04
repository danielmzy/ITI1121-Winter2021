package com.queue.my;
import java.util.*;

import javax.swing.JOptionPane;


/*
@ Author: A S M Mahfujur Rahman
*/

public class LinkedListQueue implements Queue {

	    
        
	    // Instance variables
	    
	    private Node head;  // Points to (refers to) the first node in the list, or null if none.
	    private Node tail;  // Points to (refers to) the last node in the list, or null if none.
	    
	    private int size;   // The number of elements (nodes) in the list.
	    
	    /**
	     * This constructor initializes the queue to an empty
	     * state.  (The head and tail reference 'null', and the
	     * size is set to 0.)
	     */
	    public LinkedListQueue ()
	    {
	        this.head = null;
	        this.tail = null;
	        this.size = 0;
	    }
	    
	    /**
	     * Returns the number of elements in this queue.
	     * 
	     * @return
	     *        the number of elements in this queue
	     */
	    public int size ()
	    {
	        return size;
	    }
	    
	    /**
	     * Adds an element to the end (the back) of the queue.
	     * 
	     * @param data
	     *            the data to be enqueued
	     */
	    public void enqueue (Job data)
	    {
	        // Create a new node with the data.  This node
	        // will be linked in to the list at the end of the list.
	        
	        Node n = new Node (data);
	        
	        // If the list is not empty, just link the new node
	        //   in after the tail.
	        
	        if (tail != null)
	            tail.setNext(n);
	            
	        // The end of the list is changed to reference the new node.
	        
	        tail = n;
	        
	        // If the list was empty, the head should also reference this new node.
	        
	        if (head == null)
	            head = n;
	            
	        // The list has had a node added - increase its size.    
	            
	        size++;
	    }
	    
	    
	    /**
	     * Removes an element from the start (the front) of the queue.
	     * 
	     * @return
	     *        the data stored at the start of the queue
	     * 
	     * @throws NoSuchElementException
	     *                               if the queue is empty
	     */
	    public Job dequeue ()
	    {
	        // If the queue is empty, throw an exception.
	        
	        if (size == 0)
	            throw new NoSuchElementException("Cannot remove an element from an empty queue.");
	        
	        // Get the data from the node at the front of the list.  Note that we know
	        //   the head will be non-null, the queue is not empty if we get here.
	            
	        Job temp = head.getData();
	        
	        // Point the head to the next node in the list.  This causes the first node
	        //   to become unreferenced, and it will be discarded by the garbage collector.
	        
	        head = head.getNext();
	        
	        // The list has shrunk, change the size.
	        
	        size--;
	        
	        // If the list is now empty, both the head and tail should point to null.
	        //   (Note that the head already would contain null, we don't need to change it again.)
	        
	        if (size == 0)
	            tail = null;
	            
	        // Return the data that was stored at the front of the queue.    
	            
	        return temp;
	    }
	    
	    
	    /**
	     * Is the queue empty?
	     */
	    public boolean isEmpty() {
	        return head == null;
	    }

	 
	   /**
	     * Return the item least recently added to the queue.
	     * Throw an exception if the queue is empty.
	     */
	    public Job peek() {
	    	// If the queue is empty, throw an exception.
	        
	        if (size == 0)
	            throw new NoSuchElementException("Cannot look up an element from an empty queue.");
	        
	        // Get the data from the node at the front of the list.  Note that we know
	        //   the head will be non-null, the queue is not empty if we get here.
	            
	        return head.getData();
	    }
	    
		 

	    /**
	     * Removes all the elements from the clear
	     * also sets the front and read node elements to null
	     * 
	     */
	    
	    public void clear()
	    {
	    	//while(dequeue()!=null);
	    	
	        this.head = null;
	        this.tail = null;
	        this.size = 0;
	    	
	    }
	     
	    
	    
	    public static void main(String args[])
	    {
	    	
	    	String inputValue = JOptionPane.showInputDialog("Please input a value");
	    	
	    	//default title and icon
	    	JOptionPane.showMessageDialog(null,
	    	    "Eggs are not supposed to be green."
	    	 );
	    	
	    }
	    
	    
	    /**
	     * Removes the specified element from the list.  If the
	     * data does not exist in the list, the queue is not changed.
	     * If the data occurs multiple times in the list, only
	     * the first occurrence is removed.
	     * 
	     * @param data
	     *            the data element to be removed
	     */
	    public void remove (Job data)
	    {
	        // Keep track of a 'current' node (or position) in the list, as
	        //   well as the node that links to this node.
	        
	        Node current = head;
	        Node previous = null;
	        
	        // As long as 'current' has not reached the end of the list, and
	        //   as long as it is not referencing a node that contains the
	        //   data we want to remove, loop and advance through the list.
	        
	        while (current != null && !current.containsData(data))
	        {
	            previous = current;
	            current = current.getNext();
	        }
	        
	        // If the element was not found, bail.
	        
	        if (current == null)
	            return;
	        
	        // If the element was at the start of the list, just advance
	        //   the head.  Otherwise, unlink it from the list.
	            
	        if (previous == null)
	            head = current.getNext();
	        else
	            previous.setNext(current.getNext());
	            
	        // An element has been removed, adjust the size appropriately.    
	            
	        size--;
	        
	        // If the last element was removed, adjust the tail appropriately.
	        
	        if (current == tail)
	            tail = previous;
	    }
	    
	    /**
	     * Inserts the specified element into the list immediately after 
	     * the specified placeholder element.  If the placeholder is not 
	     * in the list, no action is taken.  The data element will be 
	     * nearer to the end of the list than the placeholder.  If the
	     * placeholder element occurs multiple times in the list, the
	     * data element will be inserted after the first occurrence of the
	     * placeholder.
	     * 
	     * @param placeholder
	     *                   the data element to search for
	     * 
	     * @param data
	     *            the data element to insert
	     */
	    public void insertAfter (Job placeholder, Job data)
	    {
	         Node current = head;
	        Node previous = null;
	        
	        // As long as 'current' has not reached the end of the list, and
	        //   as long as it is not referencing a node that contains the
	        //   data we want to remove, loop and advance through the list.
	        
	        while (current != null && !current.containsData(placeholder))
	        {
	            previous = current;
	            current = current.getNext();
	        }
	        
	        // If the element was not found, bail.
	        
	        if (current == null)
	            return;

	         if (previous == null)
	            head = current.getNext();
	        else
	            previous.setNext(current.getNext());
	            
	        // An element has been removed, adjust the size appropriately.    
	            
	        size++;
	        
	        // If the last element was removed, adjust the tail appropriately.
	        
	        if (current == tail)
	            tail = previous;

	    }
	    
	    

	     
}

