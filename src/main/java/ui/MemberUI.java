package ui;

import service.MemberService;
import service.MemberServiceImpl;
import vo.GenderType;
import vo.Member;

import java.util.List;
import java.util.Scanner;

public class MemberUI {
    private final MemberService memberService;
    private Scanner scanner;

    public MemberUI() {
        memberService = new MemberServiceImpl();
        scanner = new Scanner(System.in);
        ui();
    }

    public void ui() {
        while (true) {
            System.out.println("[회원정보 관리 시스템]");
            System.out.println("1. 회원정보 등록");
            System.out.println("2. 아이디로 회원정보 조회");
            System.out.println("3. 전체 회원정보 조회");
            System.out.println("4. 회원정보 수정");
            System.out.println("5. 회원정보 삭제");
            System.out.println("6. 프로그램 종료");
            System.out.print("번호 입력 > ");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    saveMember(); break;
                case 2:
                    findMemberById(); break;
                case 3:
                    findMembers(); break;
                case 4:
                    updateMember(); break;
                case 5:
                    removeMember(); break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("** 번호를 다시 입력해 주세요");
            }
        }
    }

    // 회원정보 생성
    public void saveMember() {
        System.out.println("[회원정보 등록]");
        System.out.print("이름을 입력하세요: ");
        String name = scanner.next();
        System.out.print("성별을 입력하세요(남성은 M, 여성은 F) : ");
        String input = scanner.next();
        String gender = null;
        if (input.equalsIgnoreCase("M")) gender = "MALE";
        if (input.equalsIgnoreCase("F")) gender = "FEMALE";
        System.out.print("생년월일을 입력하세요(yyyy-mm-dd 형식): ");
        String birth = scanner.next();
        System.out.print("이메일을 입력하세요: ");
        String email = scanner.next();
        Member member = new Member(name, gender, birth, email);
        Member savedMember = memberService.saveMember(member);
        System.out.println("** 생성된 회원정보: " + savedMember);
    }

    // 아이디로 회원정보 조회
    public void findMemberById() {
        System.out.println("[아이디로 회원정보 검색]");
        System.out.print("검색할 아이디를 입력하세요: ");
        Long id = scanner.nextLong();
        Member findMember = memberService.findMemberById(id);
        if (findMember != null) {
            System.out.println("** 검색된 회원정보: " + findMember);
        } else {
            System.out.println("** 아이디[" + id + "] 에 해당하는 회원정보가 없습니다." );
        }
    }

    // 전체 회원정보 조회
    public void findMembers() {
        List<Member> members = memberService.findMembers();
        System.out.println("*** 전체 회원정보 ***");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    // 회원정보 수정
    public void updateMember() {
        System.out.println("[회원정보 수정]");
        System.out.print("수정할 회원 아이디를 입력하세요: ");
        Long id = scanner.nextLong();
        Member findMember = memberService.findMemberById(id);
        if (findMember != null) {
            System.out.println("** 검색된 회원정보: " + findMember);
            System.out.print("수정할 이름을 입력하세요: ");
            String name = scanner.next();
            findMember.setName(name);
            System.out.print("수정할 성별을 입력하세요(남성은 M, 여성은 F) : ");
            String input = scanner.next();
            String gender = null;
            if (input.equalsIgnoreCase("M")) gender = "MALE";
            if (input.equalsIgnoreCase("F")) gender = "FEMALE";
            findMember.setGender(GenderType.valueOf(gender));
            System.out.print("수정할 생년월일을 입력하세요(yyyy-mm-dd 형식): ");
            String birth = scanner.next();
            findMember.setBirth(birth);
            System.out.print("이메일을 입력하세요: ");
            String email = scanner.next();
            findMember.setEmail(email);

            Member updateMember = memberService.updateMember(findMember);
            System.out.println("** 수정된 회원정보: " + updateMember);
        } else {
            System.out.println("** 아이디[" + id + "] 에 해당하는 회원정보가 없습니다." );
        }
    }

    // 회원정보 삭제
    public void removeMember() {
        System.out.println("[회원정보 삭제]");
        System.out.print("삭제할 아이디를 입력하세요: ");
        Long id = scanner.nextLong();
        memberService.removeMember(id);
    }

    public static void main(String[] args) {
        new MemberUI();
    }
}
