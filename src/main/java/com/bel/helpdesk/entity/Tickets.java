package com.bel.helpdesk.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name ="Tickets")
@Data
@Builder
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Lob
    private String issueSummary;

    @Enumerated(EnumType.STRING)
    private Priority priority;

@PrePersist
void save(){
    if(this.createdAt==null){
        this.createdAt = new Date();
    }

}
    private Date createdAt;
    @CreationTimestamp()
    private Date updateAt;

    @Column(unique = true)
    private String userName;


    private Status status;

    private Long userContact;



}
