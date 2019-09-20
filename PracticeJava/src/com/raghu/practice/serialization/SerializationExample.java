package com.raghu.practice.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExample implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 5063913184137685841L;
	transient int x =10;
	static String s ="Raghu";
	float f = 10.0f;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		SerializationExample se= new SerializationExample();
		FileOutputStream fos = new FileOutputStream("file.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(se);
		System.out.println("Object is Deserialized");
		oos.close();
	    fos.close();
	    SerializationExample des ;
	    FileInputStream fis = new FileInputStream("file.txt");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    des = (SerializationExample) ois.readObject();
		System.out.println("Object is Deserialized");
		System.out.println("Int value after deserialization:" +des.x);
		System.out.println("String value after: "+des.s);
	}


}
