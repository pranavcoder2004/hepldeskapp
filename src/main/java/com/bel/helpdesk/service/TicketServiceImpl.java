package com.bel.helpdesk.service;

import com.bel.helpdesk.entity.Tickets;
import com.bel.helpdesk.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketsRepository repository;
    @Override
    @Transactional
    public Tickets createTicket(Tickets tickets) {
        tickets.setTicketId(null);
        return repository.save(tickets);
    }

    @Override
    public Tickets getTicketWithId(Long id) {
        var t = repository.findById(id).orElse(null);
        if(t!=null){
            return t;
        }

            return null;

    }

    @Override
    public Tickets getTicketByUserName(String name) {
        return repository.findTicketByUserName(name).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public Tickets updateTicket(Tickets tickets, Long id) {
        Tickets t = repository.findById(id).orElseThrow(()->new RuntimeException());
         t.setPriority(tickets.getPriority());
         t.setIssueSummary(tickets.getIssueSummary());
         t.setUserContact(tickets.getUserContact());
         t.setStatus(tickets.getStatus());
         return repository.save(t);
    }
}
