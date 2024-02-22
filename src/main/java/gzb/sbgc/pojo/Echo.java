package gzb.sbgc.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Echo {
	private static final Logger logger = LoggerFactory.getLogger(Echo.class);
	public Echo(String id,float sleep,float duration,long latency) {
	  logger.info(String.format("%s %.6f %.6f %d",id,sleep,duration,latency));
	}

	
	public static void writeEchoLogHeader() {
		logger.info("ECHO0001I id sleep duration latency");
	}
	
	public String getOK() {
		return("Echo OK");
	}

}
