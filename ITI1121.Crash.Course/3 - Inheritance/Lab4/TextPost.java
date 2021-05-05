class TextPost extends Post {
	
	public String message;
	
	public TextPost(String userName, String message) {
		super(userName);
		this.message = message;
	}
	
	@Override
	public boolean isPopular() {
		return likes > 50;
	}
	
	@Override
	public String toString() {
		String str = new String();
		str = super.toString() + ", " + message;
		return str;
	}
}
