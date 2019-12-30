package gzb.sbgc.pojo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Dumbo {
	private int count;
	private Dumbo prev;
	private Dumbo next;
	private static final Logger logger = LoggerFactory.getLogger(Dumbo.class);
	
	public Dumbo(String id,int count,int size, Dumbo prev) {
	  this.count=count;
	  this.prev=prev;
	  byte  b[] = new byte[size];
	  Arrays.fill(b, (byte)8);
	  this.count--;
	  if (this.count < 0) {
		  logger.debug("Last Dumbo created for " + id);
	  } else {
		  this.next = new Dumbo(id,this.count, size, this);
	  }
    }

}
