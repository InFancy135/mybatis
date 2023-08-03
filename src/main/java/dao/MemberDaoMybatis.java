package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import config.MybatisConfig;
import vo.Member;

public class MemberDaoMybatis implements MemberDao {

	private final 
	SqlSessionFactory sqlSessionFactory = MybatisConfig.getSqlSessionFactory();
	
	@Override
	public Member saveMember(Member member) {
		return null;
	}

	@Override
	public Member findMemberById(Long id) {
	      //SqlSessionFactory 에 SqlSession 객체를 얻는다
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Member member = null;
		try {
	      
	      //SqlSession과 Mapper 인터페이스를 연결한다 
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			member = mapper.findMemberById(id);
	      
		}catch(Exception e) {
	         e.printStackTrace();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return member;
	}
	
	@Override
	public List<Member> findMembers() {
		return null;
	}

	@Override
	public Member updateMember(Member member) {
		return null;
	}

	@Override
	public void removeMember(Long id) {
	}

	public static void main(String[] args) {
		MemberDao dao = new MemberDaoMybatis();
		Member member = dao.findMemberById(1L);
		System.out.println("member: " + member);
	}
}
