package gzb.sbgc.pojo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Dumby {
	
	private int count;
	private int size;
    private static AtomicInteger dumbyCount = new AtomicInteger();
	
	public Dumby(int count,int size) {
		System.out.println("Dumby");
		this.count=count;
		this.size=size;
		dumbyCount.getAndIncrement();
		System.out.println("Dumby " + dumbyCount + " created");
	}
	
	public void fillUp() {
		long d1=System.currentTimeMillis();
		for (int i=0;i<this.count;i++) {
			byte  b[] = new byte[this.size];
			Arrays.fill(b, (byte)8);
		}
		long d2=System.currentTimeMillis();
		long delta=d2-d1;
		System.out.println("Dumby " + dumbyCount + "Allocated " + this.count + " arrays of " + this.size + " bytes in " + delta + " ms");
	}
	

}
