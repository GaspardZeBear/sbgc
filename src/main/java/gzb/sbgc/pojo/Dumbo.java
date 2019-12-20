package gzb.sbgc.pojo;

import java.util.Arrays;

public class Dumbo {
	private int count;
	private Dumbo prev;
	private Dumbo next;
	public Dumbo(String id,int count,int size, Dumbo prev) {
	  this.count=count;
	  this.prev=prev;
	  byte  b[] = new byte[size];
	  Arrays.fill(b, (byte)8);
	  this.count--;
	  if (this.count < 0) {
		  System.out.println("Last Dumbo created for " + id);
	  } else {
		  this.next = new Dumbo(id,this.count, size, this);
	  }
    }

}
