package com.eric.moviego.repository;

import com.eric.moviego.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 16.
 **/
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Optional<Member> findByUsernameOrEmail(String username, String email);
    Boolean existsByUsername(@NotBlank String username);
    Boolean existsByEmail(@NotBlank String email);
}
