package gzb.sbgc.pojo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Dumbo {
	private int count;
	private long birth;
	private Dumbo prev;
	private Dumbo next;
	private Byte b[];
	private static final Logger logger = LoggerFactory.getLogger(Dumbo.class);
	
	public Dumbo(String id, int count,int size, Dumbo prev, int deepsleep) {
	  this.count=count;
	  this.prev=prev;
	  this.birth=System.nanoTime();
	  b = new Byte[size];
	  byte mb=8;
	  Arrays.fill(b, new Byte(mb));
	  this.count--;
	  if (this.count < 0) {
		  logger.debug("Last Dumbo created for " + id);
		  try {
			  Thread.sleep(deepsleep);
			  //Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
	  } else {
		  this.next = new Dumbo(id,this.count, size, this, deepsleep);
	  }
    }
	
	public long getBirth() {
		return(this.birth);
	}

}
