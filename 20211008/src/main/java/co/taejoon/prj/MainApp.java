package co.taejoon.prj;

import java.util.ArrayList;
import java.util.List;

import co.taejoon.prj.service.MemberService;
import co.taejoon.prj.service.MemberVO;
import co.taejoon.prj.serviceImpl.MemberServiceImpl;

public class MainApp {
	public static void main(String[] args) {

		MemberService memberService = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<MemberVO>();

		MemberVO vo = new MemberVO();
		vo.setId("kim1234");
		vo.setPassword("49382");
		vo.setName("김치국");
		vo.setTel(null);
		vo.setAddress(null);
		vo.setAuthor("USER");
		int n = memberService.insertMember(vo);
		if (n != 0) {
			System.out.println("입력 성공");
		} else {
			System.out.println("입력 실패");
		}
		System.out.println("==================");
		members = memberService.selectMemberList();
		for (MemberVO member : members) {
			member.toString();
		}

	}
}
