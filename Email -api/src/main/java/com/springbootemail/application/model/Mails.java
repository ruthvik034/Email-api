package com.springbootemail.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

   @Column
   private String m_from;
    @Column
    private Date sent_date ;
    @Column
    private String body;
    @Column
    private String subject;
    @Column
    private LocalDateTime retrived_date ;





}
