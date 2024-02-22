package gzb.sbgc.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import gzb.sbgc.pojo.Dumby;
import gzb.sbgc.pojo.Witness;
import gzb.sbgc.pojo.Echo;
import gzb.sbgc.pojo.Stats;
import gzb.sbgc.pojo.Fibo;
/**
 *
 * @GaspardZeBear
 *
 */
@Controller
@EnableAutoConfiguration
public class HelloWorldController {
	
//	private static final Logger dumbyLogger = LoggerFactory.getLogger("Dumby");
//	private static final Logger witnessLogger = LoggerFactory.getLogger("Witness");
@RequestMapping("/hello")
@ResponseBody
  public String sayHello() {
     return "Hello GZB Developer!!!";
}


@RequestMapping("/reset")
@ResponseBody
  public String reset() {
	 Dumby.reset();
     return "Dumby resetted";
}

@RequestMapping("/stats")
@ResponseBody
  public Stats stats() {
	 Stats s = new Stats();
     return(s);
}

@RequestMapping(value="/dumby/{maxIndex}/{count}/{size}/{sleep}/{deepsleep}")
@ResponseBody
  public Dumby dumby(@PathVariable("maxIndex") int maxIndex,@PathVariable("count") int count,@PathVariable("size") int size,@PathVariable("sleep") int sleep,@PathVariable("deepsleep") int deepsleep) {
	Dumby d = new Dumby(maxIndex,count,size,sleep,deepsleep) ;
    //return "Hello dumby done";
	return(d);
}

@RequestMapping(value="/witness/{sleep}")
@ResponseBody
  public Witness witness(@PathVariable("sleep") long sleep) {
	return(new Witness(sleep));
}

@RequestMapping(value="/fibo/{c}/{n}")
@ResponseBody
  public Fibo fibo(@PathVariable("c") int c,@PathVariable("n") int n) {
	return(new Fibo(c,n));
}

@RequestMapping(value="/echo/{id}/{sleep}/{duration}/{latency}")
@ResponseBody
  public Echo echo(@PathVariable("id") String id, @PathVariable("sleep") float sleep,@PathVariable("duration") float duration, @PathVariable("latency") long latency) {
	return(new Echo(id,sleep,duration,latency));
}
}