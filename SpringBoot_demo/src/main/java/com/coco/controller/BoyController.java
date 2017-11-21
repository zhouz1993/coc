package com.coco.connectmysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Administrator
 *
 */
@RestController
public class BoyController {
	
	@Autowired
	private BoyRepository boyRepository;

	@Autowired
	private BoyService boyService;
	/**
	 * 查询boy列表
	 * @return
	 */
	@RequestMapping(value="/boy",method = RequestMethod.GET)
	public List<Boy> boyList(){
		return boyRepository.findAll();
	}
	
	/**
	 * 添加一个boy
	 * @param name
	 * @param age
	 * @return
	 */
	@GetMapping("/addboy")
	public Boy boyAdd(@RequestParam("name") String name,
						@RequestParam("age") Integer age){
		Boy boy = new Boy();
		boy.setName(name);
		boy.setAge(age);
		
		return boyRepository.save(boy);
	}
	
	/**
	 * 查询一个boy
	 * @param id
	 * @return
	 */
	@GetMapping(value="/boy/{id}")
	public Boy boyFindOne(@PathVariable("id") Integer id){
		return boyRepository.findOne(id);
	}
	
	@RequestMapping(value="/boys/{id}",method = RequestMethod.GET)
	public Boy updateBoy(@PathVariable("id") Integer id,
						@RequestParam("name") String name,
						@RequestParam("age") Integer age){
		Boy boy = new Boy();
		boy.setId(id);
		boy.setName(name);
		boy.setAge(age);
		
		return boyRepository.save(boy);
	}
	
	//删除
	@GetMapping(value="/delete/{id}")
	public void boyDelete(@PathVariable("id") Integer id){
		boyRepository.delete(id);
	}
	
	@GetMapping(value="/age/{age}")
	public List<Boy> boyListByAge(@PathVariable("age") Integer age){
		return boyRepository.findByAge(age);
	}
	
	@GetMapping(value = "/two")
	public void boyTwo(){
		boyService.insertTwo();
	}
	
	
}













