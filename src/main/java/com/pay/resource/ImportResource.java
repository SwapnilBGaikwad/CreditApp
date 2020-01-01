package com.pay.resource;

import com.google.inject.Inject;
import com.pay.model.Bill;
import com.pay.model.Spend;
import com.pay.service.SpendImportService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/credit")
@Produces(MediaType.APPLICATION_JSON)
public class ImportResource {
    private SpendImportService service;

    @Inject
    public ImportResource(SpendImportService service) {
        this.service = service;
    }

    @POST
    public Spend add(Spend spend) {
        service.add(spend);
        return spend;
    }

    @GET()
    public Bill getBillingDetails() {
        return service.getTotal();
    }
}
