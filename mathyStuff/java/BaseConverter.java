/*
 * Here's a function that converts any value from the following bases (2,3,4,5,6,7,8,9,10,16)
 * and converts it into its appropriate base 10 number.
 * It's smart enough to handle invalid values for a given number system and invalid bases.
 */
public class BaseConverter {
	/**
	 * Convert a number from any base to an integer.
	 * Supported bases are: 2,3,4,5,6,7,8,9,10, and 16.
	 * Returns -1 if number or base is invalid.
	 * @param number The number as a string.
	 * @param base The base of the value as an integer.
	 * @return the value as an integer in base 10.
	 */
	public static int convertToInt(String number, int base) {
		// ensure base is valid before computing value
		if (base < 2 || base > 10 && base != 16)
			return -1;

		// compute value by summing powers
		int sum = 0;
		for (int i = number.length()-1; i >= 0; i--) {
			int digit = valueOfChar(number.charAt(i));
			if (digit >= base) return -1;
			int placeVal = number.length()-1-i;
			sum += digit * Math.pow(base, placeVal);
		}
		return sum;
	}

	/**
	 * Helper function that converts an individual character value
	 * into its respective base 10 value. Throws illegalArgument exception
	 * if the value to convert is not a valid
	 * @param val the character to be converted into an integer
	 * @return the converted integer value from the character
	 */
	private static int valueOfChar(char val) {
		// make uppercase if lower
		if (val >= 'a' && val <= 'f')
			val -= ('a' - 'A');

		// ensure val is valid
		if (val >= '0' && val <= '9' || val >= 'A' && val <= 'F') {
			switch (val) {
				case 'A': return 10;
				case 'B': return 11;
				case 'C': return 12;
				case 'D': return 13;
				case 'E': return 14;
				case 'F': return 15;
				default: return Integer.parseInt(Character.toString(val));
			}
		} else throw new IllegalArgumentException("Can't convert '" + val + "' to a valid integer.");
	}

	public static void main(String[] args) {
		String base2Val = "10101010";
		String base3Val = "12012012";
		String base4Val = "12301230";
		String base5Val = "12340123";
		String base6Val = "12345012";
		String base7Val = "12345601";
		String base8Val = "12345670";
		String base9Val = "12345678";
		String base10Val= "123456789";
		String base16Val= "a74fcF";

		System.out.println(convertToInt(base2Val,2));
		System.out.println(convertToInt(base3Val,3));
		System.out.println(convertToInt(base4Val,4));
		System.out.println(convertToInt(base5Val,5));
		System.out.println(convertToInt(base6Val,6));
		System.out.println(convertToInt(base7Val,7));
		System.out.println(convertToInt(base8Val,8));
		System.out.println(convertToInt(base9Val,9));
		System.out.println(convertToInt(base10Val,10));
		System.out.println(convertToInt(base16Val,16));


	}

}
