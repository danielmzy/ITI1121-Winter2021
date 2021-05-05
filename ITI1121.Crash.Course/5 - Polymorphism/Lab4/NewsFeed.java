
/*
Student name: Glen Wang
Student number: 300164126
Course: ITI 1121
Lab section: B-1
*/


/**
* The class News feed
* @author Glen Wang
*/
public class NewsFeed {
	
	private Post[] messages;
	private int size = 0;
	
	// public static final int MAX_SIZE = 25;
	private int initialCapacity = 25;
	private int capacityIncrement = 25;
	
	/**
	*
	* Constructs a news feed
	*
	*/
	public NewsFeed() {
		
		messages = new Post[initialCapacity];
	}
	
	
	/**
	*
	* Constructs a news feed
	*
	* @param the initial capacity
	* @param the capacity increment
	*/
	public NewsFeed(int initialCapacity, int capacityIncrement) {
		
		
		this.initialCapacity = initialCapacity;
		this.capacityIncrement = capacityIncrement;
		messages = new Post[initialCapacity];
	}
	
	
	/**
	*
	* Adds a message
	*
	* @param the message
	*/
	public void add(Post message) {
		
		// if (size >= messages.length) {
		// 	Post[] temp = new Post[messages.length + capacityIncrement];
		// 	System.arraycopy(messages, 0, temp, 0, messages.length);
		// 	messages = temp;
		// } // uncomment for dynam message size
		if (size >= initialCapacity) {
			System.out.println("size reached, dynamic array functionality currently commented out");
			return;
		}
		messages[size] = message;
		size++;
	}
	
	
	/**
	*
	* Gets the message at an index
	*
	* @param the index
	* @return the message
	*/
	public Post get(int index) {
		
		
		return messages[index];
	}
	
	
	/**
	*
	* Gets the size
	*
	* @return the size
	*/
	public int size() {
		
		
		return size;
	}
	
	
	/**
	*
	* Sorts the posts by date, oldest to most recent
	*
	*/
	public void sort(){
		
		
		int i, j, argMin;
		Post tmp;
		for (i = 0; i < size - 1; i++) {
			argMin = i;
			for (j = i + 1; j < size(); j++) {
				if (messages[j].compareTo(messages[argMin]) < 0) {
					argMin = j;
				}
			}
			
			tmp = messages[argMin];
			messages[argMin] = messages[i];
			messages[i] = tmp;
		}
		
	}
	
	
	/**
	*
	* Returns a news feed with only photo posts
	*
	*/
	public NewsFeed getPhotoPost() {
		
		
		NewsFeed photos = new NewsFeed();
		for (int i = 0; i < size; i++) {
			if (messages[i] instanceof PhotoPost) {
				photos.add(messages[i]);
			}
		}
		return photos;
	}
	
	
	/**
	*
	* Combines two news feeds
	*
	* @param the other news feed
	*/
	public NewsFeed plus(NewsFeed other) {
		
		
		NewsFeed feed = new NewsFeed();
		for (int i = 0; i < size; i++) {
			feed.add(messages[i]);
		}
		for (int i = 0; i < other.size(); i++) {
			feed.add(other.get(i));
		}
		feed.sort();
		return feed;
	}
}
