package com.bel.helpdesk.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name ="Tickets")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Lob
    private String summary;

    @Enumerated(EnumType.STRING)
    private Priority priority;

@PrePersist
void save(){
    if(this.createdAt==null){
        this.createdAt = new Date();
    }
    this.updateAt =new Date();

}

    private Date createdAt;


    @CreationTimestamp()
    private Date updateAt;

    @Column(unique = true)
    private String userName;


    private Status status;

    private Long userContact;



}
