package com.eric.moviego.model.role;

import com.eric.moviego.model.member.Member;
import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 16.
 **/
@Embeddable
@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberRoleId implements Serializable {

    private Member member;
    private Role role;

}