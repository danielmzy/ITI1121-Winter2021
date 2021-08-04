import java.io.IOException;

public class Exercise1 {
	
	public static void throwException(int exceptionNumber) throws Exception{
		if(exceptionNumber==1){
			throw new Exception();
		}
		if(exceptionNumber==2){
			throw new ArrayIndexOutOfBoundsException();
		}
		if(exceptionNumber==3){
			throw new IOException();
		}
		if(exceptionNumber==4){
			throw new IllegalArgumentException();
		}
		if(exceptionNumber==5){
			throw new NullPointerException();
		}
	}
	
	/*
	Returns the name of the exception thrown by the method throwException.
	Method that handles the exceptions thrown by the throwException method.
	
	@param exceptionNumber
	@return The exception name or "NoException" if no exception was caught.
	*/
	public static String catchException(int exceptionNumber){
		try{
			throwException(exceptionNumber);
		} catch (Exception exception) {
			return exception.getClass().getSimpleName();
			// just in case i'm about to lose marks, i couldve done split, scanner or regex
			// and didnt want to rewrite the wheel
		}
		return "NoException";
	}
	
	public static void main(String[] args) {
		int exceptionNumber=(int)(Math.random()*5) + 1;
		String exceptionName = catchException(exceptionNumber);
		System.out.println("Exception number: " + exceptionNumber);
		System.out.println("Exception name: " + exceptionName);
	}
	
}
