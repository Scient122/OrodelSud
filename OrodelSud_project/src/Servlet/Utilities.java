package Servlet;

import java.io.*;
import java.util.Base64;

public class Utilities {

	public static String convertImage(InputStream stream)throws IOException {
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		byte [] buffer=new byte[52428800]; //50mb
		int bytesRead=-1;
			
			bytesRead=stream.read(buffer);
			out.write(buffer,0,bytesRead);
			byte[] imageBytes=out.toByteArray();
			String base64Image=Base64.getEncoder().encodeToString(imageBytes);
			stream.close();
			out.close();
			 
		return base64Image;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
