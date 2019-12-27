package com.pay.resource;

import com.google.inject.Inject;
import com.pay.model.Bill;
import com.pay.model.Credit;
import com.pay.service.CreditService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/credit")
@Produces(MediaType.APPLICATION_JSON)
public class ImportResource {
    private CreditService service;

    @Inject
    public ImportResource(CreditService service) {
        this.service = service;
    }

    @POST
    public Credit addStudent(Credit credit) {
        service.add(credit);
        return credit;
    }

    @GET()
    public Bill getBillDetails() {
        return service.getTotal();
    }
}
