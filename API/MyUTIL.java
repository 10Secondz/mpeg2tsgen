package API;
/**
 * 
 */

/**
 * @author SungHun Park (sainthh@tvstorm.com)
 *
 */
public class MyUTIL {
	protected static final String white_space = " ";

	public static String whiteSpaceStr(int length) {
		if (length < 0)
			throw new IllegalArgumentException();
		String str = new String();
		for(int n=0; n < length; n++)
			str += white_space;
		return str;
	}
	
	public static String toBinaryString(byte b) {
		String str = new String();
		for(int s = Byte.SIZE-1; s >= 0; s--) {
			if (((b>>s)&0x1) != 0)
				str += "1";
			else
				str += "0";
		}
		return str;
	}
	
	public static String toBinaryString(byte[] bs) {
		if (bs == null)
			throw new NullPointerException();

		String str = new String();
		for(int n=0; n < bs.length; n++) {
			str += toBinaryString(bs[n]);
			if ((n+1) < bs.length)
				str += "_";
		}

		return str;
	}
	
	public static String toBinaryString(byte[] bs, int num_bytes_in_line) {
		if (bs == null)
			throw new NullPointerException();

		String str = new String();
		for(int n=0; n < bs.length; n++) {
			str += toBinaryString(bs[n]);
			if ((n+1) < bs.length)
				str += "_";
			if (((n+1) % num_bytes_in_line) == 0)
				str += "\n";
		}

		return str;
	}
	
	public static String toBinaryString(int i) {
		String str = new String();
		for(int s = Integer.SIZE-1; s >= 0; s--) {
			if (((i>>s)&0x1) != 0)
				str += "1";
			else
				str += "0";
		}
		return str;
	}
	
	public static String toBinaryString(long l) {
		String str = new String();
		for(int s = Long.SIZE-1; s >= 0; s--) {
			if (((l>>s)&0x1) != 0)
				str += "1";
			else
				str += "0";
		}
		return str;
	}
	
	public static String toBinaryString(short d) {
		String str = new String();
		for(int s = Short.SIZE-1; s >= 0; s--) {
			if (((d>>s)&0x1) != 0)
				str += "1";
			else
				str += "0";
		}
		return str;
	}

}
