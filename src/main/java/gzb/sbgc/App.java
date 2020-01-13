package gzb.sbgc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gzb.sbgc.pojo.Dumby;
import gzb.sbgc.pojo.Witness;
import gzb.sbgc.pojo.Echo;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	@PostConstruct
    private void init() {
		String version = System.getProperty("java.version");
		logger.info("APP0001I java version " + version);
	    RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
	    List<String> jvmArgs = bean.getInputArguments();
        for (String jvmArg : jvmArgs) {
          logger.info("APP0001I " + jvmArg);
        }
       logger.info("APP0001I -classpath " + System.getProperty("java.class.path"));
       Dumby.writeDumbyLogHeader();
       Witness.writeWitnessLogHeader();
       Echo.writeEchoLogHeader();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
