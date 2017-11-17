package com.coco.apple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Administrator
 *@RestController 相当于@Controller @ResponseBody 同时使用
 */
@RestController
//@Controller
//@ResponseBody
//@RequestMapping(value={"/coc"})
public class GirlController {
	
	@Autowired
	private Girl girl;
	
	/**
	 * 多个路径对应同一个功能
	 * @RequestMapping(value="/girl",method=RequestMethod.GET)
	 * @RequestMapping(value={"/girl","/hi"},method=RequestMethod.GET)
	 * @return
	 */
	@RequestMapping(value={"/girl","/hi"},method=RequestMethod.POST)
	public String getGirl(){
		return girl.toString();
	}
}
