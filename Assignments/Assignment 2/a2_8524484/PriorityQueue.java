
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
        
        //checks if the queue is empty
        public boolean isEmpty()
        {        
                // TODO Implement this method
                return tail == 0; // will return true if empty.
                					// the last element of the queue is tail.
                // if queue is empty, true else false
        }
        
        //adds an element to the queue
        public void enqueue(Job element)
        {
                // TODO Implement this method
        	
        	if (tail >= heap.length){ 	//when the array is full
        		resize(); 				//double the size
        	}
        		heap[tail] = element; 	//assign the new variable
        		reverseHeapify(tail);	//conserve the heap property
        		tail++;					// increment tail
        		
        		
        		
        }
        
        //removes an element from the queue
        public Job dequeue()
        {
        	if(isEmpty()){ 				// when queue is empty, will not dequeue
			 return null;
		}
        	Job root = heap[0];			//root of the array heap

           if(tail==1) {				//when root is the last element of the array heap
        		tail=0;				 	// so queue size is 0, thus tail is 0
        	}
	       	else { 						// when the array heap has more than 1 element in the queue
        		heap[0]=heap[tail-1]; 	// make the root the last element
        		tail--;					//decrement tail
        		heapify(0); 			//restore the heapify property from the first element
        	}
           
            return root;
        }
 
        
        // clearing the whole queue
        public void clear()
        {
                // TODO Implement this method
        	 for (int i = 0; i < heap.length; i++){ //every index in the array would point to nothing
        		 heap[i] = null; // scrubbing memory
        	 }
        	 tail = 0;							// so the tail would be reset as 0
        }
        
        //doubles the size of the queue
        private void resize()
        {
                // TODO Implement this method
        	
        		int size = heap.length; 	//storing the current size of the array heap
        		Job [] newHeap = new Job[size *2];	 //doubling the size of array heap to new array
        		
        		//when array heap is full
        		for(int i = 0; i < size; i++) {
        			newHeap[i] = heap[i]; //every element of array heap is assigned to that of newHeap
        		}
        		
        		heap = newHeap;			// heap is assigned as new array
        		//thus the size to the array heap doubles
        }
        
        //conserves the heap property
        private void reverseHeapify(int i)
        {
        	  if ( i == 0 ) { 			//when the root is at 0
        	     return; 
        	   } 
 
	       	  int p = parent(i); //parent of child i

        	  // Compare the parent  and the child 
        	  // if  child  is higher than parent, then swap occurs
 
      	 	 if( heap[i].getOwner() > heap[p].getOwner())
        	   { 
       		  		swap(i, p);
        		  	reverseHeapify( p ); // compare the grandparent with parent
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
