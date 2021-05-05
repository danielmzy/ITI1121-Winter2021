public class TextPost extends Post {

    private String message;

    public TextPost(String userName, String message) {
      super(userName);
      this.message = message;
    }

    public String getMessage() {
	     return message;
    }

    public String toString() {
    	String str = new String();
    	str = super.toString() + ", " + message;
    	return  str;
    }

  	public boolean isPopular() {
      if (super.getLikes() > 50){
        return true;
      }
      else{
        return false;
      }
  	}

}
