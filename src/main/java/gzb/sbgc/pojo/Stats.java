package gzb.sbgc.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import gzb.sbgc.pojo.Dumby;

public class Stats {
	private static final Logger logger = LoggerFactory.getLogger(Stats.class);
	private int dumbyCount;
	private int dumbySize;
	private int dumbySizeMB;
	public Stats() {
		computeSize();
	}

	public void computeSize() {
		dumbySize=Dumby.computeDumboesSize();
		dumbySizeMB=dumbySize/(1024*1024);
	}
	public static void writeEchoLogHeader() {
		logger.info("ECHO0001I id sleep duration latency");
	}
	
	public int getDumbySize() {
		return(dumbySize);
	}
	
	public int getDumbySizeMB() {
		return(dumbySizeMB);
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
		//System.out.println(dumbyId + " heapTotal " + heapSize + " heapMaxSize " + heapMaxSize + " heapFreeSize " + heapFreeSize);
        return(false);
	}

}
