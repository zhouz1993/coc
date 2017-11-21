package com.coco.apple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamController {

	@RequestMapping(value="/param/{id}",method=RequestMethod.GET)
	public String getParamValue(@PathVariable("id") Integer param){
		return "param : "+param;
	}
	
//	@RequestMapping(value="/param2",method=RequestMethod.GET)
	@GetMapping("/param2")
	public String getParamValue2(@RequestParam("id") Integer param){
		return "param : "+param;
	}
	
	@RequestMapping(value="/param3",method=RequestMethod.GET)
	public String getParamValue3(@RequestParam(value="id",required = false,defaultValue = "0") Integer param){
		return "param : "+param;
	}
}






















