package gzb.sbgc.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author manoj.bardhan
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
}