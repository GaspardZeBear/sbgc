package gzb.sbgc.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import gzb.sbgc.pojo.Dumby;
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
  public String dumby(@PathVariable("count") int count,@PathVariable("size") int size) {
	Dumby d = new Dumby(count,size) ;
	d.fillUp();
    return "Hello dumby done";
}
}