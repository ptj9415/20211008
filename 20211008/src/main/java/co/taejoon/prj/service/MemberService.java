package co.taejoon.prj.service;

import java.util.List;

public interface MemberService {
   List<MemberVO> selectMemberList();
   MemberVO selMember(MemberVO vo); 
   int insertMember(MemberVO vo);  
   int updateMember(MemberVO vo);  
   int deleteMember(MemberVO vo);
 
}