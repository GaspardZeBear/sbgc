package gzb.sbgc.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Witness {
		private long sleep;
		private double duration;
		private String startDate;
		private static final Logger logger = LoggerFactory.getLogger(Witness.class);
		
		public Witness(long sleep) {

			this.sleep=sleep;
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(System.currentTimeMillis());
			startDate=formatter.format(date);
			long d1=System.nanoTime();
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
			}
			long d2=System.nanoTime();
			duration=(double)(d2-d1)/1_000_000;
			logger.info(String.format("startDate %s sleep %d duration %.6f ",startDate,sleep,duration));
		}
		
		public double getDuration() {
			return(duration);
		}
		
		public String getStartDate() {
			return(startDate);
		}
		
		public double getSleep() {
			return(this.sleep);
		}

}