package com.src.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.src.enitities.User;
@Repository

public  interface UserRepo extends JpaRepository<User,String> {

    Optional<User>findByEmail(String email);


}
