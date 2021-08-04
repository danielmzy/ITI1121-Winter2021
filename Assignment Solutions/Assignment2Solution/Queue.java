package com.queue.my;

/*
@ Author: A S M Mahfujur Rahman
*/


public interface Queue
{
        // TODO Fill in interface
	
	/**
     * Test if the queue is logically empty.
     * @return true if empty, false otherwise.
     */
	 public boolean isEmpty();
     
     /**
      * Insert a new item into the queue.
      * @param x the item to insert.
      */
     public void enqueue(Job element);
     
     /**
      * Return and remove the least recently inserted item
      * from the queue.
      * @return the least recently inserted item in the queue.
      * @exception UnderflowException if the queue is empty.
      */
     public Job dequeue();
     
     /**
      * Make the queue logically empty.
      */
     public void clear();
     
}