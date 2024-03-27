package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	@Autowired
	private SqlSession sqlSession;

	// 리스트
	public List<PersonVo> personSelect() {

		System.out.println("phonebookdao.personSelect()");

		List<PersonVo> personList = sqlSession.selectList("phonebook.select");

		return personList;
	}

	// 등록
	public int personInsert(PersonVo personVo) {
		System.out.println("phonebookdao.personInsert()");

		int count = sqlSession.insert("phonebook.insert", personVo);

		return count;
	}

	// 글1개 가져오기
	public PersonVo phonebookSelectOne(int no) {
		System.out.println("phonebookdao.phonebookSelectOne()");

		PersonVo personVo = sqlSession.selectOne("phonebook.selectOneWrite", no);
		System.out.println(personVo);
		return personVo;
	}

	// 삭제
	public int personDelete(int no) {
		System.out.println("phonebookdao.personDelete()");

		int count = sqlSession.delete("phonebook.delete", no);

		return count;
	}

	// 수정폼
	public PersonVo personSelectOne(int no) {
		System.out.println("phonebookdao.personSelectOne");

		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", no);

		return personVo;
	}

	// 수정
	public int personUpdate(PersonVo personVo) {

		int count = sqlSession.update("phonebook.update", personVo);
		System.out.println(count);
		return count;
	}
}
