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
/**
 *
 * @GaspardZeBear
 *
 */
@Controller
@EnableAutoConfiguration
public class HelloWorldController {
	
	private static final Logger dumbyLogger = LoggerFactory.getLogger("Dumby");
	private static final Logger witnessLogger = LoggerFactory.getLogger("Witness");
@RequestMapping("/hello")
@ResponseBody
  public String sayHello() {
     return "Hello GZB Developer!!!";
}

@RequestMapping(value="/dumby/{maxIndex}/{count}/{size}/{sleep}")
@ResponseBody
  public Dumby dumby(@PathVariable("maxIndex") int maxIndex,@PathVariable("count") int count,@PathVariable("size") int size,@PathVariable("sleep") int sleep) {
	Dumby d = new Dumby(maxIndex,count,size,sleep) ;
    //return "Hello dumby done";
	return(d);
}

@RequestMapping(value="/witness/{sleep}")
@ResponseBody
  public Witness witness(@PathVariable("sleep") long sleep) {
	return(new Witness(sleep));
}
}