package gzb.sbgc.pojo;

import java.util.concurrent.atomic.AtomicInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Dumby {
	
	private int count;
	private double duration;
	private int size;
	private int idx;
	private String dumbyId;
	private String startDate;
    private static AtomicInteger dumbyCount = new AtomicInteger();
    private final static int DUMBOES_SIZE = 1024 ;
    private static Dumbo dumboes[] = new Dumbo[DUMBOES_SIZE];
	
	public Dumby(int count,int size) {
		//System.out.println("Dumby");
		this.count=count;
		this.size=size;
		dumbyCount.getAndIncrement();
		this.idx=dumbyCount.intValue() % DUMBOES_SIZE;
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
	
	public double getDuration() {
		return(duration);
	}
	
	public String getStartDate() {
		return(startDate);
	}
	

	public void fillDumboes() {
		long d1=System.nanoTime();
		long alloc= (this.count * this.size) / (1024) ;
		dumboes[this.idx]=new Dumbo(dumbyId,this.count, this.size,null);
		long d2=System.nanoTime();
		duration=(double)(d2-d1)/1_000_000;
		System.out.println(dumbyId 
				+ " Allocated " + this.count 
				+ " arrays of " + this.size  
				+ " bytes " + alloc + " kb "
				+ " in slot " + this.idx  
				+ " duration " + duration + " ms");
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
