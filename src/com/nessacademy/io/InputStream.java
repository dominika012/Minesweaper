package com.nessacademy.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.nessacademy.entity.Player;

public class InputStream {

	public void inputStream(){
		 ObjectInputStream in = null;
		    try {
		      in = new ObjectInputStream(new FileInputStream("test.txt"));
		      int count = in.readInt();
		      while (count-- > 0) {
		        Object o = in.readObject();
		        Player p = (Player) o;
		        System.out.println(p);
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (ClassNotFoundException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }

	}
	
}
