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
		System.out.println("=====��� ����=====");
		System.out.println("1. ��ü ��� ��ȸ");
		System.out.println("2. ȸ�� ��ȸ");
		System.out.println("3. ȸ�� ���");
		System.out.println("4. ȸ������ ����");
		System.out.println("5. ȸ������ ����");
		System.out.println("6. ����");
		System.out.println("���ϴ� ��ȣ�� �����ϼ���.");

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
		System.out.println("�˻��� ȸ���� ID�� �Է��ϼ���.");
		vo.setId(sc.nextLine());
		vo = memberService.selMember(vo);
		vo.toString();
		System.out.println("Enter Key�� ��������.");
		sc.nextLine();
	}

	private void insertMember() {
		MemberVO vo = new MemberVO();

	}

	private void updateMember() {
		MemberVO vo = new MemberVO();
		System.out.println("ȸ�� ������ �����մϴ�.");
		System.out.println("------------------");
		System.out.println("������ ȸ���� ID�� �Է��ϼ���.");
		vo.setId(sc.nextLine());
		System.out.println("�̸��� �Է��ϼ���.");
		vo.setName(sc.nextLine());
		System.out.println("��й�ȣ�� �Է��ϼ���.");
		vo.setPassword(sc.nextLine());
		System.out.println("��ȭ��ȣ�� �Է��ϼ���.");
		vo.setTel(sc.nextLine());
		System.out.println("�ּҸ� �Է��ϼ���.");
		vo.setAddress(sc.nextLine());
		System.out.println("������ �Է��ϼ���.(ADMIN or USER)");
		vo.setAuthor(sc.nextLine());
		int n = memberService.updateMember(vo);
		if (n != 0) {
			System.out.println("���������� �߰��Ǿ����ϴ�.");
		} else {
			System.out.println("�߰��� �����Ͽ����ϴ�.");
		}
		System.out.println("�ƹ� Ű�� �����ּ���.");
		sc.nextLine();
	}

	private void deleteMember() {
		MemberVO vo = new MemberVO();
		System.out.println("������ ȸ���� ID�� �Է��ϼ���.");
		vo.setId(sc.nextLine());
		int n = memberService.deleteMember(vo);
		if (n != 0) {
			System.out.println("���������� �����Ǿ����ϴ�.");
		} else {
			System.out.println("���� �����Ͽ����ϴ�.");
		}
		System.out.println("�ƹ� Ű�� �����ּ���.");
		sc.nextLine();
	}

}
