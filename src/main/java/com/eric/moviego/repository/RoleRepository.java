package com.eric.moviego.repository;

import com.eric.moviego.model.role.Role;
import com.eric.moviego.model.role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 19.
 **/
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}