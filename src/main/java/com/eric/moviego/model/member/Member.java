package com.eric.moviego.model.member;

import com.eric.moviego.config.BooleanToYNConverter;
import com.eric.moviego.model.common.BaseEntity;
import com.eric.moviego.model.role.MemberRole;
import com.eric.moviego.model.role.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 16.
 **/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "member")
@NamedEntityGraph(
        name = "Member.roles",
        attributeNodes = @NamedAttributeNode(value = "roles", subgraph = "Member.roles.role"),
        subgraphs = @NamedSubgraph(name = "Member.roles.role", attributeNodes = @NamedAttributeNode("role"))
)
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "username")
    @Size(max = 15)
    private String username;

    @NotBlank
    @NaturalId
    @Size(max = 40)
    @Column(name = "email")
    @Email
    private String email;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(max = 100)
    @Column(name = "password")
    private String password;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean isActive;

    //    @ManyToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JoinTable(name = "member_role", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    //@OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade =CascadeType.ALL)
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MemberRole> roles;

    public Member(String username, String email, String password, List<Role> roles, boolean isActive) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.roles = roles.stream().map(r -> new MemberRole(this, r)).collect(toSet());
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void deActive() {
        this.isActive = false;
    }

    public void updateMember(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
