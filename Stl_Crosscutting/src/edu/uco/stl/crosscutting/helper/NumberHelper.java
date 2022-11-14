package edu.uco.stl.crosscutting.helper;

public class NumberHelper {
	
	private NumberHelper() {
		super();
	}
	
	public static final byte ZERO = 0;
	
	public static final <T extends Number> T getDefaultNumber(T value, T defaultValue) {	
		return getDefaultNumber(value, defaultValue); 
	}
	
	public static final <T extends Number> Number getDefaultNumber(T value) {
		return getDefaultNumber(value, ZERO); 
	}
	
	public static final <T extends Number> boolean isGreaterThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() > getDefaultNumber(numberTwo).doubleValue();
	}
	
	
	public static final <T extends Number> boolean isLessThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() < getDefaultNumber(numberTwo).doubleValue();
	}
	
	
	public static final <T extends Number> boolean isEqualsThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() == getDefaultNumber(numberTwo).doubleValue();
	}
	
	public static final <T extends Number> boolean isGreaterOrEquialsThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() >= getDefaultNumber(numberTwo).doubleValue();
	}
	
	
	public static final <T extends Number> boolean isLessOrEquals(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() <= getDefaultNumber(numberTwo).doubleValue();
	}
	
	
	public static final <T extends Number> boolean isDiferentThan(T numberOne, T numberTwo) {
		return !isEqualsThan(numberOne, numberTwo);
	}
	
	public static final <T extends Number> boolean isZero(T number) {
        return number.equals(ZERO);
    }

}
