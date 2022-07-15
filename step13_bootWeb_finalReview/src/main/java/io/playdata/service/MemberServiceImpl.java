package io.playdata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.playdata.dao.MemberRepository;
import io.playdata.domain.Member;

/* MemberSerice interface에서 implements로 받아와서 해당 메소드를 완성. @Service annotation으로 실질적인 service역할 명시
 * MemberRepository의 singleton객체 사용. -> 여기로 넘어가서 추가 process 정보 확인 */
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepo;

	public Member getMember(Member member) {
		/* Optional<T>는 null이 올 수 있는 값을 감싸는 Wrapper 클래스로, 참조하더라도 NPE가 발생하지 않도록 도와준다. 
		 * Optional 클래스는 특정 value에 값을 저장하기 때문에 값이 null이더라도 바로 NPE가 발생하지 않으며, 클래스이기 때문에 각종 메소드를 제공함.*/
		Optional<Member> findMember = memberRepo.findById(member.getId());
		if (findMember.isPresent()) {
			return findMember.get();
		}else {
			return null;
		}
	}
}
