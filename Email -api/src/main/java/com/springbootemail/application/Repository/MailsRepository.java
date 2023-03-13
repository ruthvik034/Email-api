package com.springbootemail.application.Repository;

import com.springbootemail.application.model.Mails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository

public interface MailsRepository extends JpaRepository<Mails,Integer> {

}
