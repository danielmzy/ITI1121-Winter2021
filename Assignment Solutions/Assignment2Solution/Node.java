package com.queue.my;

/**
 * This class defines 'node' objects, which are the
 * parts of the linked list used in the queue class above.
 * A single Queue object may create and link together
 * many Node objects.  <p>
 * 
 * Note that this class is inside of the Queue class.  This
 * does not cause problems.  The class is private because we
 * only want to use it within the Queue class. <p>
 * 
 * In the in-class demo, nodes were designed to be singly-linked
 * (forward only).  The next assignment requires you to convert
 * the Queue and the Node classes to use / represent a
 * doubly-linked list.  Nodes will have two references, one that
 * points forwards, and one that points backwards. <p>
 * 
 */
 
/*
@ Author: A S M Mahfujur Rahman
*/

public class Node
{
    // Instance variables.
    
    private Job data;       // The data stored in the node.
    private Node next;      // A reference to the next node in the list, or null if none.
    
    /**
     * Creates a node containing the specified data,
     * and linking to nothing.
     * 
     * @param data
     * the data to store in this node
     */
    public Node (Job data)
    {
        this.data = data;
        this.next = null;
    }

    /**
     * Returns the data stored in this node.
     * 
     * @return
     *        the data stored in this node
     */
    public Job getData ()
    {
        return data;
    }

    /**
     * Returns the Node object that follows this
     * Node object.  This method is used to traverse
     * the linked list.
     * 
     * @return
     *        the node that follows this node
     */
    public Node getNext()
    {
        return next;
    }
    
    /**
     * Causes this Node object to be linked to
     * the specified node.  The specified node will
     * follow, or come after, this node.
     * 
     * @param n
     *          the node to be placed after this node
     */
    public void setNext(Node n)
    {
        next = n;
    }
    
    /**
     * Returns true if this node contains the specified
     * data.  This is just a helper method to make it easier
     * to allow null values to be stored in the queue.  Nulls
     * can be safely compared with this method.
     * 
     * @param data
     *            a data element to compare to the data in this node
     *            
     * @return 
     *        true if the data elements are equal, false otherwise
     */
    public boolean containsData (Job data)
    {
        if (this.data == null || data == null)
            return this.data == data;
        else
            return this.data.equals(data);
    } 
    
}
