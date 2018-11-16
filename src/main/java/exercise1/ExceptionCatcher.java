package exercise1;

public class ExceptionCatcher {
	private final ExceptionThrower exceptionThrower;

	public ExceptionCatcher(ExceptionThrower exceptionThrower) {
		this.exceptionThrower = exceptionThrower;
	}

	void executeExceptionThrowerSafely(int value) {
		try {
			exceptionThrower.throwACustomExceptionWhenValueIs42(value);
		}
		catch(RuntimeException e){
			System.out.println("runtime exception, cérifie tes maths !");

		}
		finally{
			System.out.println("le programme continue");
		}
	}

}
