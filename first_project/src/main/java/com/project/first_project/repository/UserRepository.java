package com.project.first_project.repository;

import com.project.first_project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
        //custom quiries

    Optional<UserEntity> findByUsername(String username);

    //exists kiyana kotasa aniwa ona.eken thama jpa eka danaganne(auto setupquery)
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
