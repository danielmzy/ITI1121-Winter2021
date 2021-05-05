/*public class PhotoPost extends Post {

    private String fileName;
    private String caption;

    public PhotoPost(String userName, String fileName, String caption) {
      super(userName);
      this.fileName = fileName;
      this.caption = caption;
    }

    public String getCaption() {
	     return caption;
    }

    public String getFileName() {
	     return fileName;
    }

    public String toString() {
    	String str = new String();
    	str = super.toString() + ", " + fileName + ", " + caption;
    	return str;
    }

}
*/

public class PhotoPost extends Post {
    
    private String fileName;
    private String caption;
    
    
    /**
    *
    * Constructs a photo post
    *
    * @param userName  the user name
    * @param fileName  the file name
    * @param caption  the caption
    */
    public PhotoPost(String userName, String fileName, String caption) {
        
        super(userName);
        this.fileName = fileName;
        this.caption = caption;
    }
    
    
    /**
    *
    * Gets the caption
    *
    * @return the caption
    */
    public String getCaption() {
        
        return caption;
    }
    
    
    /**
    *
    * Gets the file name
    *
    * @return the file name
    */
    public String getFileName() {
        
        return fileName;
    }
    
    
    @Override
    public String toString() {
        
        String str = new String();
        str = super.toString() + ", " + fileName + ", " + caption;
        return str;
    }
}
