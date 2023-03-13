package com.springbootemail.application.Repository;

import com.springbootemail.application.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository

public interface UsersRepository extends JpaRepository<Users,Long> {

    public Users findByEmail(String s);
}
