package dao;

import java.util.*;
import vo.Member;

import java.util.List;

public interface MemberDao {
    // 회원정보 생성
    public Member saveMember(Member member);

    // 아이디로 회원정보 조회
    public Member findMemberById(Long id);

    // 전체 회원정보 조회
    public List<Member> findMembers();

    // 회원정보 수정
    public Member updateMember(Member member);

    // 아이디로 회원정보 삭제
    public void removeMember(Long id);

}
