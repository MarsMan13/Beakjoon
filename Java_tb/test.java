import java.util.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Main{
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException{
		
		String msg = "Hello my name is choigochoigun";
		byte[] ret = sha256(msg);
		for(byte b : ret)
			System.out.printf("%x", b);
		System.out.println();
		String ret2 = bytesToHex1(ret);
		System.out.println(ret2);
		System.out.println(ret2.length());
	}
	public static byte[] sha256(String msg) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());
		return md.digest();
	}		

	public static String bytesToHex1(byte[] bytes){
		StringBuilder sb = new StringBuilder();
		for(byte b : bytes){
			System.out.println(b & 0xff);
			System.out.println(String.format("%02x", b));
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

}

