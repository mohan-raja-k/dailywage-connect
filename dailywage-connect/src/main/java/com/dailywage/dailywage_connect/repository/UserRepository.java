package com.dailywage.dailywage_connect.repository;

import com.dailywage.dailywage_connect.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {
    @Query("Select u from UserModel u Where UPPER(u.userCity) = UPPER(:city)")
    List<UserModel> findBycity(String city);

    @Query("Select u from UserModel u Where UPPER(u.userRole) = UPPER(:role)")
    List<UserModel> findByrole(String role);
}
