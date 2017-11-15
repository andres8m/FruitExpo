package com.example.inventory.controllers;


import com.example.common.validators.auth.user.AuthenticatedUser;
import com.example.common.validators.auth.user.Secured;
import com.example.inventory.controllers.request.LoadRequest;
import com.example.inventory.models.Load;
import com.example.users.beans.UserBean;
import com.example.users.models.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("/inventory")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InventoryController {

    @EJB
    UserBean userBean;

    @Inject
    @AuthenticatedUser
    User user;

    @POST
    @Path("/load")
    @Secured
    public Load createLoad(@Valid LoadRequest request)
    {
        Load load = new Load();
        load.setDate(new Date());
        load.setQuantity(request.getQuantity());
        load.setEmployee(request.getEmployee());
        return load;
    }




}
