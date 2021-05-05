/*import java.util.Calendar;
import java.util.Date;

public class Post implements Likeable, Comparable<Post> {

    protected int likes;
    private Date timeStamp;
    private String userName;

    public Post(String userName) {
      this.userName = userName;
      this.timeStamp = Calendar.getInstance().getTime();
      this.likes = 0;
    }

    public String getUserName() {
	     return userName;
    }

    public Date getTimeStamp() {
	     return timeStamp;
    }

    // Implement the methods required by the interface Likeable.
    // This file will not compile unless they are present with the correct name and signature.
    public void like() {
      likes = likes + 1;
    }

    public int getLikes() {
      return likes;
    }

    public String toString() {
    	String str = new String();
    	str = getClass().getName() + ": " + timeStamp + ", " + userName + ", likes = " + likes;
    	return  str;
    }


  	public int compareTo(Post other){
      int compareTo = timeStamp.compareTo(other.timeStamp);
  		return compareTo;
  	}

  	public boolean isPopular(){
      if (likes > 100){
        return true;
      } 
      else{
        return false;
      }
  	}

}
*/

import java.util.Calendar;
import java.util.Date;


/**
* The class Post
* @author Glen Wang
*/
public class Post implements Likeable, Comparable<Post> {
  
  protected int likes;
  private Date timeStamp;
  private String userName;
  
  
  /**
  *
  * Constructs a post
  *
  * @param userName  the user name
  */
  public Post(String userName) {
    
    this.userName = userName;
    timeStamp = Calendar.getInstance().getTime();
  }
  
  
  /**
  *
  * Gets the user name
  *
  * @return the user name
  */
  public String getUserName() {
    
    return userName;
  }
  
  
  /**
  *
  * Gets the time stamp
  *
  * @return the time stamp
  */
  public Date getTimeStamp() {
    
    return timeStamp;
  }
  
  @Override
  public String toString() {
    
    String str = new String();
    str = getClass().getName() + ": " + timeStamp + ", " + userName + ", likes = " + likes;
    return str;
  }
  
  
  
  @Override
  public int compareTo(Post other){
    int delta = other.getLikes() - likes;
    return delta == 0 ? timeStamp.compareTo(other.getTimeStamp()) : delta;
  }
  
  
  /**
  *
  * Whether likes pass a threshold
  *
  * @return boolean
  */
  public boolean isPopular(){
    
    return likes > 100;
  }
  
  
  @Override
  public void like() {
    
    likes++;
  }
  
  
  @Override
  public int getLikes() {
    
    return likes;
  }
}