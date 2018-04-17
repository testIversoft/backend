package com.iversoft.test.persistence.DAO;

import com.iversoft.test.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
