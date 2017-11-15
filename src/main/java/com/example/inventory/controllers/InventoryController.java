package com.example.inventory.controllers;


import com.example.common.validators.auth.user.AuthenticatedUser;
import com.example.common.validators.auth.user.Secured;
import com.example.inventory.beans.EmployeeBean;
import com.example.inventory.beans.InventoryBean;
import com.example.inventory.controllers.request.LoadRequest;
import com.example.inventory.controllers.response.DischargeResponse;
import com.example.inventory.controllers.response.LoadResponse;
import com.example.inventory.models.Discharge;
import com.example.inventory.models.Employee;
import com.example.inventory.models.Load;
import com.example.users.beans.UserBean;
import com.example.users.models.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/inventory")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InventoryController {

    @EJB
    UserBean userBean;

    @Inject
    @AuthenticatedUser
    User user;

    @EJB
    InventoryBean inventoryBean;

    @EJB
    EmployeeBean employeeBean;

    @POST
    @Path("/load")
    @Secured
    public Load createLoad(@Valid LoadRequest request)
    {
        Load load = new Load();
        load.setDate(new Date());
        load.setQuantity(request.getQuantity());
        load.setEmployee(request.getEmployee());
        inventoryBean.persistLoad(load);
        return load;
    }

    @GET
    @Path("/loads")
    @Secured
    public List<LoadResponse> allLoads()
    {
        List<Load> loads = inventoryBean.allLoads();
        List<LoadResponse> response = new ArrayList<>();

        for(Load x: loads)
        {
            LoadResponse loadResponse = new LoadResponse();
            Employee employee = employeeBean.byId(x.getEmployee());
            loadResponse.setEmployee(employee);
            loadResponse.setLoad(x);
            response.add(loadResponse);
        }

        return response;
    }

    @GET
    @Path("/discharges")
    @Secured
    public List<DischargeResponse> allDischarges()
    {
        List<Discharge> loads = inventoryBean.allDischarges();
        List<DischargeResponse> response = new ArrayList<>();

        for(Discharge x: loads)
        {
            DischargeResponse loadResponse = new DischargeResponse();
            Employee employee = employeeBean.byId(x.getEmployee());
            loadResponse.setEmployee(employee);
            loadResponse.setDischarge(x);
            response.add(loadResponse);
        }

        return response;
    }




}
