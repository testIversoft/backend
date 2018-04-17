package com.iversoft.test.persistence.DAO;

import com.iversoft.test.persistence.model.UserAddresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressesRepository extends JpaRepository<UserAddresses,Integer> {
}
