package dao;

import java.util.List; 
import vo.Member;

public interface MemberMapper {
	int saveMember(Member member);
	Member findMemberById(Long id);
	List<Member> findMembers();
}
