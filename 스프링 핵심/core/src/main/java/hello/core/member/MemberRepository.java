package hello.core.member;

public interface MemberRepository {

    // Member 객체를 매개변수로 받아서 회원정보를 저장하는 메서드
    void save(Member member);

    // 회원 고유 식별자를 매개변수로 받아 해당 회원 정보를 조회하는 메서드
    // 반환 타입은 Member 클래스
    Member findById(Long memberId);
}
