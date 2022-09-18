package com.eric.moviego.model.role;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 16.
 **/
@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "name", nullable = false, unique = true)
//    private RoleName name;
//
//
//    public Role(RoleName name) {
//        this.name = name;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName name;

    public Role(RoleName name) {
        this.name = name;
    }
}
