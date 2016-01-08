package com.nessacademy.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.nessacademy.services.MyTimer;

public class Player {

	String date;
	MyTimer myTimer;
	
	public String getDate(){
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

	      return ft.format(dNow);
	}
	
}
