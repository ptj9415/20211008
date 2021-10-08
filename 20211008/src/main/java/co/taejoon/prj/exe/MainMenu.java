package co.taejoon.prj.exe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.taejoon.prj.service.MemberService;
import co.taejoon.prj.service.MemberVO;
import co.taejoon.prj.serviceImpl.MemberServiceImpl;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	MemberService memberService = new MemberServiceImpl();

	private void menuTitle() {
		System.out.println("===================");
		System.out.println("=====멤버 관리=====");
		System.out.println("1. 전체 목록 조회");
		System.out.println("2. 회원 조회");
		System.out.println("3. 회원 등록");
		System.out.println("4. 회원정보 수정");
		System.out.println("5. 회원정보 삭제");
		System.out.println("6. 종료");
		System.out.println("원하는 번호를 선택하세요.");

	}

	public void run() {
		while (true) {
			menuTitle();
			int key = sc.nextInt();
			sc.nextLine();
			switch (key) {
			case 1:
				selectMemberList();
				break;
			case 2:
				selectMember();
				break;
			case 3:
				insertMember();
				break;
			case 4:
				updateMember();
				break;
			case 5:
				deleteMember();
				break;
			case 6:
				sc.close();
				return;
			}
		}
	}

	private void selectMemberList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = memberService.selectMemberList();
		list.toString();
		System.out.println();
	}

	private void selectMember() {
		MemberVO vo = new MemberVO();
		System.out.println("검색할 회원의 ID를 입력하세요.");
		vo.setId(sc.nextLine());
		vo = memberService.selMember(vo);
		vo.toString();
		System.out.println("Enter Key를 누르세요.");
		sc.nextLine();
	}

	private void insertMember() {
		MemberVO vo = new MemberVO();

	}

	private void updateMember() {
		MemberVO vo = new MemberVO();
		System.out.println("회원 정보를 수정합니다.");
		System.out.println("------------------");
		System.out.println("수정할 회원의 ID를 입력하세요.");
		vo.setId(sc.nextLine());
		System.out.println("이름을 입력하세요.");
		vo.setName(sc.nextLine());
		System.out.println("비밀번호를 입력하세요.");
		vo.setPassword(sc.nextLine());
		System.out.println("전화번호를 입력하세요.");
		vo.setTel(sc.nextLine());
		System.out.println("주소를 입력하세요.");
		vo.setAddress(sc.nextLine());
		System.out.println("권한을 입력하세요.(ADMIN or USER)");
		vo.setAuthor(sc.nextLine());
		int n = memberService.updateMember(vo);
		if (n != 0) {
			System.out.println("정상적으로 추가되었습니다.");
		} else {
			System.out.println("추가에 실패하였습니다.");
		}
		System.out.println("아무 키나 눌러주세요.");
		sc.nextLine();
	}

	private void deleteMember() {
		MemberVO vo = new MemberVO();
		System.out.println("삭제할 회원의 ID를 입력하세요.");
		vo.setId(sc.nextLine());
		int n = memberService.deleteMember(vo);
		if (n != 0) {
			System.out.println("정상적으로 삭제되었습니다.");
		} else {
			System.out.println("삭제 실패하였습니다.");
		}
		System.out.println("아무 키나 눌러주세요.");
		sc.nextLine();
	}

}
