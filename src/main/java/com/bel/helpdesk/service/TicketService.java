package com.bel.helpdesk.service;

import com.bel.helpdesk.entity.Tickets;
import org.springframework.stereotype.Service;


public interface TicketService {
    Tickets createTicket(Tickets tickets);
    Tickets getTicketWithId(Long id);
    Tickets getTicketByUserName(String name);
    Tickets updateTicket(Tickets tickets , Long id);
}
