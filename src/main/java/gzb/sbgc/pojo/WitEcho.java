package gzb.sbgc.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WitEcho {
	private static final Logger logger = LoggerFactory.getLogger(WitEcho.class);
	public WitEcho(float sleep,float duration,long latency) {
	  logger.info(String.format("WITECHO0001I %.6f %.6f %d",sleep,duration,latency));
	}

	
	public static void writeWitEchoLogHeader() {
		logger.info("WITECHO0001I sleep duration latency");
	}
	
	public String getOK() {
		return("WitEcho OK");
	}

}
