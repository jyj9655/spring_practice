package com.mycompany.practice.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.practice.member.model.dao.MemberDao;
import com.mycompany.practice.member.model.vo.Member;

@Service("MemberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao MemberDao;
	
	@Override
	public int join(Member m) throws Exception {
		return MemberDao.join(m);
	}
}
