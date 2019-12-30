package gzb.sbgc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gzb.sbgc.pojo.Dumby;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	public static void main(String[] args) {
		
		RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
		List<String> jvmArgs = bean.getInputArguments();

	    for (String jvmArg : jvmArgs) {
	      logger.info(jvmArg);
	    }
	    logger.info("-classpath " + System.getProperty("java.class.path"));
		SpringApplication.run(App.class, args);
		}

}
