
/*
Student name: Glen Wang
Student number: 300164126
Course: ITI 1121
Lab section: B-1
*/


/**
* The class Text post
* @author Glen Wang
*/
public class TextPost extends Post {
	
	private String message;
	
	
	/**
	*
	* Constructs a text post
	*
	* @param userName  the user name
	* @param message  the message
	*/
	public TextPost(String userName, String message) {
		super(userName);
		this.message = message;
	}
	
	
	/**
	*
	* Gets the message
	*
	* @return the message
	*/
	public String getMessage() {
		return message;
	}
	
	
	@Override
	public String toString() {
		String str = new String();
		str = super.toString() + ", " + message;
		return  str;
	}
	
	@Override
	public boolean isPopular() {
		return likes > 50;
	}
}
