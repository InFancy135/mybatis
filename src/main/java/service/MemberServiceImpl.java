package service;

import java.util.List;

import dao.*;
import vo.Member;

public class MemberServiceImpl implements MemberService {
	
	private final MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoMybatis();
	}

	@Override
	public Member saveMember(Member member) {
		// 유효성 체크
		return memberDao.saveMember(member);
	}

	@Override
	public Member findMemberById(Long id) {
		return memberDao.findMemberById(id);
	}

	@Override
	public List<Member> findMembers() {
		return memberDao.findMembers();
	}

	@Override
	public Member updateMember(Member member) {
		return memberDao.updateMember(member);
	}

	@Override
	public void removeMember(Long id) {
		// 회원 아이디가 없을 경우 삭제하지 않음
		memberDao.removeMember(id);
	}

}
