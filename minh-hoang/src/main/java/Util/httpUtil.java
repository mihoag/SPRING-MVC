package Util;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class httpUtil {
 private String value;
 public httpUtil(String value)
 {
	 this.value = value;
 }
 
 public static httpUtil of(BufferedReader reader) throws IOException
 {
	 StringBuilder str = new StringBuilder();
	 String line;
	 while((line = reader.readLine()) != null)
	 {
		 str.append(line);
	 }
	 return new httpUtil(str.toString());	 
 }
 
 public <T> T toModel(Class<T> tclass)
 {
	 try {
		return new ObjectMapper().readValue(value, tclass);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	 return null;
 }
 
}
