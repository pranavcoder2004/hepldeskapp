package com.bel.helpdesk.repository;

import com.bel.helpdesk.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets,Long> {

    Optional<Tickets>findTicketByUserName(String userName);
}
