package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@RestController
public class PhonebookController {

	@Autowired
	private PhonebookService phonebookService;
	
	//리스트
	@GetMapping(value = "/api/phonebooks")
	public List<PersonVo> list() {
		System.out.println("PhonebookController.list()");
		
		List<PersonVo> pList = phonebookService.exeList();
		
		return pList;
	}
	//등록
	@PostMapping(value = "/api/phonebooks")
	public PersonVo write(@RequestBody PersonVo personVo) {
		System.out.println("PhonebookController.write()");
		
		PersonVo pVo = phonebookService.exeWrite(personVo);
		
		return pVo;
	}
	
	//삭제
	@DeleteMapping(value="/api/phonebooks/{personId}")
	public int remove(@PathVariable (value="personId") int no) {
		System.out.println("PhonebookController.remove()");
		
		
		System.out.println(no);
		
		int count = phonebookService.exeDelete(no);
		
		return count;
	}
	
	//수정폼
	@GetMapping(value="/api/phonebooks/{personId}")
	public PersonVo modifyform(@PathVariable (value="personId") int no) {
		System.out.println("PhonebookController.modifyform()");
		
		PersonVo personVo = phonebookService.exeModifyForm(no);
		System.out.println(personVo);
		
		
		return personVo;
	}
	
	//수정
	@PutMapping(value="/api/phonebooks/{personId}")
	public int modify(@RequestBody PersonVo personVo,
					  @PathVariable (value="personId") int no) {
		System.out.println("PhonebookController.modifyform()");
		
		personVo.setPersonId(no);
		
		int count  = phonebookService.exeUpdate(personVo);
		
		return count;
	}
}
