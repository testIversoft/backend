package com.iversoft.test.persistence.DAO;

import com.iversoft.test.persistence.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {
}
