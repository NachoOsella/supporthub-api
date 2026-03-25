package com.supporthub.api.users.repository;

import com.supporthub.api.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
