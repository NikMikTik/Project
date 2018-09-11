package com.campaign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campaign.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUserEmail(String userEmail);

}
