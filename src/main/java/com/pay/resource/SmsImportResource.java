package com.pay.resource;

import com.google.inject.Inject;
import com.pay.model.Bill;
import com.pay.model.Message;
import com.pay.service.SpendImportService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/credit")
@Produces(MediaType.APPLICATION_JSON)
public class SmsImportResource {
    private SpendImportService service;

    @Inject
    public SmsImportResource(SpendImportService service) {
        this.service = service;
    }

    @POST
    public Response add(Message message) {
        service.add(message);
        return Response.ok().build();
    }

    @GET()
    public Bill getBillingDetails() {
        return service.getTotal();
    }
}
