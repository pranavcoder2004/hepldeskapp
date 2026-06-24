package com.bel.helpdesk.tool;

import com.bel.helpdesk.entity.Tickets;
import com.bel.helpdesk.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataBaseTool {
    @Autowired
    TicketService ticketService;

    @Tool(name = "create_Ticket",description = "it is used to create ticket")
    public String createTicket(@ToolParam(description = "its is required to create new ticket") Tickets tickets){
        try {
            Tickets t = ticketService.createTicket(tickets);
            log.info("tools are running");
            return "ticket created  with id " + t.getTicketId();
        } catch (RuntimeException e) {
            System.out.println("error block " + e);
            return null;
        }

    }


    @Tool(name="getTicket",description = "used to get the ticket with username")
    public Tickets getTicket(@ToolParam(description = "used to send data ") String username){
        return ticketService.getTicketByUserName(username);
    }
    @Tool(name="updateTicket",description = "used to update ticket")
    public Tickets getTicket(@ToolParam(description = "used to send data ") Tickets tickets,@ToolParam(description = "send userId") Long userId){
        return ticketService.updateTicket(tickets,userId);
    }

    @Tool(name = "current_time",description = "to get the current datetime")
    public String getTime(){
        return String.valueOf(System.currentTimeMillis());
    }
}
