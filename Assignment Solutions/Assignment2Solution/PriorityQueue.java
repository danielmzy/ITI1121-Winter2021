package com.queue.my;

/*
@ Author: A S M Mahfujur Rahman
*/


public class PriorityQueue implements Queue
{
        private Job[] heap;
        private int tail;

        /**
         * The constructor creates an empty array for the heap and sets the tail to 0.
         */
        public PriorityQueue()
        {
                heap = new Job[10];
                tail = 0;
        }
        
        /**
         * Returns whether there are elements inside the priority queue
         */
        public boolean isEmpty()
        {        
                // tail points to the last entry of the array, hence if tail is zero then the queue is empty
                return tail==0;
        }
        
        /**
         * enqueue adds an element to the end of the heap (the tail). Since the heap is stored as an array, this 
         * simply means adding an element at the tail and incrementing the tail. However, we must ensure that the 
         * heap property is maintained. Since the last element in the heap cannot have any children it must be a leaf 
         * so we can call reverseHeapify to enforce the heap property. Also, if the heap is too small to add a new element, 
         * we must call resize before adding the element.
         */
        public void enqueue(Job element)
        {
        	// Ensure that the size of the array is greater than the tail, otherwise
        	// increment the size
        	if(tail>=heap.length)
        		resize();
        	
        	// Add the elements
        	heap[tail]=element;
        	// To ensure heap property we call reverseheapify
        	reverseHeapify(tail);
        		
        	// increment the number of elements in the array
        	tail=tail +1;
        	
        }
        
        /**
         * dequeue removes the first element in the heap and returns it. The challenge is that we cannot leave the 
         * beginning of the array empty. We cannot shift the other elements forward either, not only is this inefficient 
         * but it will also destroy the heap property. The trick is to realize that we can replace the first element with 
         * absolutely any element in the heap so long as heapify is called. There is only one element that can be moved 
         * without destroying the heap property: the last element. Thus, we swap the first element and the last element of 
         * heap, remove and return the last element and then call heapify on the first element.
         */
        public Job dequeue()
        {
        	// If the queue is empty then nothing to return
        	if(isEmpty()) return null;
        	
        	Job rootElement= heap[0];
        	
        	if(tail==1) // The root was the last element in the array
        	{ 	// set the queue size zero
        		tail=0; 
        	}
        	else if(tail==2) //There is only one element after the root is dequeued
        	{	// Shift the last child element to the root
        		heap[0]=heap[tail-1];
        		
        		// Decrease the size of the queue
        		tail = tail -1;    		
        		
        	}
        	else // There are more than two elements in the queue
        	{
        		// Shift the last child element to the root
        		heap[0]=heap[tail-1];
        		
        		// Decrease the size of the queue
        		tail = tail -1;
        		
        		// heapify the array from the start
        		heapify(0); 
        		
        	}
                
            return rootElement;
        }
        
        /**
         * Clears the content of the priority queue
         */
        public void clear()
        {
        	// Clear the content of the array with the default size
        	// The tail should now be set to zero to indicate no elements present in the array
        	heap = new Job[10];
            tail = 0;
        }
        
        
        /**
         * This method resizes the array by doubling the size of it
         * It preserves the element in the process
         */
        private void resize()
        {
        	int oldSize = heap.length;
        	Job [] newArray = new Job[oldSize * 2]; 

            // we assume that the old array is full 
            for (int i=0; i<oldSize; i++) { 
                newArray[i] = heap[i]; 
            } 
            heap = newArray;
        }
        
        
       /**
        * reverseHeapify works by comparing the current node with its parent. It
        * the current node is larger than its parent then it swaps itself with its parent.
        * The parent still might not be correct, it now needs to compare its parent with its 
        * grand parent, and so on, until it reaches the top of the tree. reverseHeapify is easy 
        * to implement using a while loop which keeps going until parent is larger than the child. 
        * While the parent is smaller than the child it swaps the parent with the child and makes 
        * then moves up to the parent (so that the parent will become the child during the next 
        * iteration of the loop). 
        * @param i The index of the child node that we are not certain if it satisfied the
         * heap property.
        */
        private void reverseHeapify(int i)
        {
        	 // If we reach to the root, the iteration stops
        	  if ( i == 0 ) 
        	   { 
        	     return; 
        	   } 

        	  // Get the parent node of the child i
        	  int parentNode = parent(i); 

        	  // Compare the priority of the parent node and the child node
        	  // if priority of the child node is higher then swap occurs
        	  if( heap[i].getOwner() > heap[parentNode].getOwner())
        	   { 
        		  swap(i, parentNode);
        		  reverseHeapify( parentNode ); 
        	   }
               
        }
        
        /**
         * Given an array index i, this method returns the array index of the i's
         * parent node in the heap.
         * 
         * @param i The index of the node for whom's parent we are searching.
         * @return The index in the array of i's parent.
         */
        private int parent(int i)
        {
                return (int) Math.floor((i - 1) / 2.0f);
        }
        
        /**
         * Given an array index i, this method returns the array index of the i's
         * left child node in the heap.
         * 
         * @param i The index of the node for whom's left child we are searching.
         * @return The index in the array of i's left child.
         */
        private int left(int i)
        {
                return 2 * i + 1;
        }
        
        /**
         * Given an array index i, this method returns the array index of the i's
         * right child node in the heap.
         * 
         * @param i The index of the node for whom's right child we are searching.
         * @return The index in the array of i's right child.
         */
        private int right(int i)
        {
                return 2 * i + 2;
        }
        
        /**
         * Swaps the Job's at position i and j.
         * 
         * @param i the array index of one of the job's to be swapped.
         * @param j the array index of the other job to be swapped.
         */
        private void swap(int i, int j)
        {
                Job temp = heap[i];
                heap[i] = heap[j];
                heap[j] = temp;
        }
        
        /**
         * Heapify works by comparing the current internal node with its children 
         * to see which is the largest. If the root is not the largest then it is 
         * swapped with the largest of its children. Since the child has now been 
         * altered it needs to check to make sure it still satisfies the heap property. 
         * Heapify works its way down the tree in this manner and, when it is complete, 
         * the tree should again be a heap. The details of how Heapify works are a 
         * little complex but the method is provided for you, you just need to 
         * understand when to use it.
         * 
         * The purpose of heapify is to restore the heap property after one of the 
         * internal nodes of the heap has been altered. In the case of a priority queue,
         * this internal nodes get altered during dequeue operations.
         * 
         * @param i The index of the node that we are not certain if it satisfied the
         * heap property (one or both of its children might be larger).
         */
        private void heapify(int i)
        {
                int l = left(i);
                int r = right(i);
                int largest = i;
                
                if (l < tail && 
                    heap[l].getOwner() > heap[largest].getOwner())
                {
                        largest = l;
                }
                
                if (r < tail &&
                    heap[r].getOwner() > heap[largest].getOwner())
                {
                        largest = r;
                }
                
                if (largest != i)
                {
                        swap(i, largest);
                        heapify(largest);
                }
        }        
}