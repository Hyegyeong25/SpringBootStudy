package me.hyegyeong.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // DB에서 데이터를 가져오는 퍼시스턴트 계층 역할
}
