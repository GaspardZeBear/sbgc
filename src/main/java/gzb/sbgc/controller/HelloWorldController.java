package gzb.sbgc.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
@RequestMapping("/hello")
@ResponseBody
  public String sayHello() {
     return "Hello GZB Developer!!!";
}

@RequestMapping(value="/dumby/{count}/{size}")
@ResponseBody
  public Dumby dumby(@PathVariable("count") int count,@PathVariable("size") int size) {
	Dumby d = new Dumby(count,size) ;
    //return "Hello dumby done";
	return(d);
}

@RequestMapping(value="/witness/{sleep}")
@ResponseBody
  public Witness witness(@PathVariable("sleep") long sleep) {
	return(new Witness(sleep));
}
}