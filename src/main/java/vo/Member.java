package vo;

public class Member {
	private Long id;				// 회원정보 일련번호(시퀀스 사용)
	private String name;			// 이름
	private GenderType gender;		// 성별
	private String birth;			// 생년월일
	private String email;			// 이메일
	
	public Member() {}
	
	public Member(Long id, String name, String gender, String birth, String email) {
		this(name, gender, birth, email);
		this.id = id;
	}
	
	public Member(String name, String gender, String birth, String email) {
		this.name = name;
		this.gender = GenderType.valueOf(gender);
		this.birth = birth;
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public GenderType getGender() {
		return gender;
	}
	
	public void setGender(GenderType gender) {
		this.gender = gender;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", gender=" + gender + ", birth=" + birth + ", email=" + email
				+ "]";
	}
	
}
