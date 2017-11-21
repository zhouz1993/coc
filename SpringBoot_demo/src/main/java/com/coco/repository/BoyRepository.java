package com.coco.connectmysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoyRepository extends JpaRepository<Boy, Integer>{
	
	//通过年龄来查询
	public List<Boy> findByAge(Integer age);
}
