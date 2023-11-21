package com.deepak.userinfo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepak.userinfo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
