import java.util.Calendar;
import java.util.Date;

class Post {
	
	public int likes;
	public Date timeStamp;
	public String userName;
	
	public Post(String userName) {
		this.userName = userName;
		timeStamp = Calendar.getInstance().getTime();
	}
	
	public String toString() {
		String str = new String();
		str = getClass().getName() + ": " + timeStamp + ", " + userName + ", likes = " + likes;
		return str;
	}
	
	public int compareTo(Post other) {
		return timeStamp.compareTo(other.timeStamp);
	}
	
	public boolean isPopular() {
		return likes > 100;
	}
	
	public void like() {
		likes++;
	}
}
