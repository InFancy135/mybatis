package dao;

import vo.Member;

public interface MemberMapper {
	Member findMemberById(Long id);
}
