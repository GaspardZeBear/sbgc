package gzb.sbgc.pojo;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Dumby {
	
	private int count;
	private double duration;
	private int sleep;
	private int size;
	private int idx;
	private int maxIndex;
	private String dumbyId;
	private String startDate;
    private static AtomicInteger dumbyCount = new AtomicInteger();
    private final static int DUMBOES_SIZE = 32767 ;
    private static Dumbo dumboes[] = new Dumbo[DUMBOES_SIZE];
	private static final Logger logger = LoggerFactory.getLogger(Dumby.class);
	
	public Dumby(int maxIndex,int count,int size,int sleep) {
		this.count=count;
		this.size=size;
		this.maxIndex=maxIndex;
		this.sleep=sleep;
		dumbyCount.getAndIncrement();
		this.idx=dumbyCount.intValue() % maxIndex;
		dumbyId="Dumby-" + dumbyCount;
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		startDate=formatter.format(date);
		fillDumboes();
	}
	
	public String getId() {
		return(dumbyId);
	}
	
	public int getSize() {
		return(size);
	}
	
	public int getCount() {
		return(count);
	}
	public int getSleep() {
		return(sleep);
	}
	
	public double getDuration() {
		return(duration);
	}
	
	public String getStartDate() {
		return(startDate);
	}
	

	public void fillDumboes() {
		long d1=System.nanoTime();
		long alloc= (this.count * this.size) / (1024) ;
		long lifetime=0;
		synchronized("Dumby-" + this.idx ) {
		  if (dumboes[this.idx] != null) {
			lifetime=d1-dumboes[this.idx].getBirth();
		  }
		  dumboes[this.idx]=new Dumbo(dumbyId, this.count, this.size,null);
		}
		try {
			Thread.sleep(this.sleep);
		} catch (InterruptedException e) {
		}
		long d2=System.nanoTime();

		duration=(double)(d2-d1)/1_000_000;
	
		String msg = String.format("DUMBY0001I dumbyId %s count %d size %d alloc %d kB index %d maxIndex %d duration %.6f ms sleep %d ms lifetime %d ms",
				this.dumbyId,
				this.count, 
				this.size,  
				alloc, 
				this.idx, 
				this.maxIndex,
				duration,
				this.sleep,
				lifetime/1_000_000);
		logger.info(msg);
	}
	
	private boolean memoryLeft() {
	    long heapSize = Runtime.getRuntime().totalMemory();
        long heapMaxSize = Runtime.getRuntime().maxMemory();
        long heapFreeSize = Runtime.getRuntime().freeMemory(); 
        float freeRatio = (float)heapFreeSize/heapMaxSize ;
		// System.out.println(dumbyId + " heapSize " + heapSize + " heapMaxSize " + heapMaxSize + " heapFreeSize " + heapFreeSize +  " freeRatio " + freeRatio);

        if ( freeRatio > 0.60 ) {
        	return(true);
        } 
		System.out.println(dumbyId + " heapTotal " + heapSize + " heapMaxSize " + heapMaxSize + " heapFreeSize " + heapFreeSize);
        return(false);
	}
	

}
