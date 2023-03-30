package com.example.testhiber.repository;

import com.example.testhiber.modelHiber.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
