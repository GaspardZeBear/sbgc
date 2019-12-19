package gzb.sbgc.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Witness {
		private long sleep;
		private double duration;
		private String startDate;
		
		public Witness(long sleep) {
			System.out.println("Dumby");
			this.sleep=sleep;
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			Date date = new Date(System.currentTimeMillis());
			startDate=formatter.format(date);
			long d1=System.nanoTime();
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
			}
			long d2=System.nanoTime();
			duration=(double)(d2-d1)/1_000_000;
		}
		
		public double getDuration() {
			return(duration);
		}
		
		public String getStartDate() {
			return(startDate);
		}

}