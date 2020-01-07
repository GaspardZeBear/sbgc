package gzb.sbgc.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Witness {
		private long sleep;
		private double duration;
		//private double processCpuLoad;
		private String startDate;
		private static final Logger logger = LoggerFactory.getLogger(Witness.class);
		
		public static void writeWitnessLogHeader() {
			logger.info("WITNESS0001I sleep duration");
		}
		
		public Witness(long sleep) {
			this.sleep=sleep;
			//SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//Date date = new Date(System.currentTimeMillis());
			OperatingSystemMXBean bean = ManagementFactory.getOperatingSystemMXBean();
			//this.processCpuLoad=bean.getSystemLoadAverage();		
			//startDate=formatter.format(date);
			long d1=System.nanoTime();
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
			}
			long d2=System.nanoTime();
			duration=(double)(d2-d1)/1_000_000;
			//logger.info(String.format("WITNESS0001I startDate %s sleep %d duration %.6f ms",startDate,sleep,duration));
			logger.info(String.format("WITNESS0001I %d %.6f",sleep,duration));
		}
		
		public double getDuration() {
			return(duration);
		}
		
		public String XgetStartDate() {
			return(startDate);
		}
		
		public double getSleep() {
			return(this.sleep);
		}

}