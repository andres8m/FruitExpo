package com.example.inventory.controllers;


import com.example.common.validators.auth.user.AuthenticatedUser;
import com.example.common.validators.auth.user.Secured;
import com.example.inventory.beans.EmployeeBean;
import com.example.inventory.beans.InventoryBean;
import com.example.inventory.controllers.request.DischargeRequest;
import com.example.inventory.controllers.request.LoadRequest;
import com.example.inventory.controllers.request.ProductDischargeRequest;
import com.example.inventory.controllers.response.DischargeDetailsResponse;
import com.example.inventory.controllers.response.DischargeResponse;
import com.example.inventory.controllers.response.LoadResponse;
import com.example.inventory.models.*;
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

    @POST
    @Path("/discharge")
    @Secured
    public Discharge createDischarge(@Valid DischargeRequest request)
    {
        Discharge discharge = new Discharge();
        discharge.setDate(new Date());
        discharge.setEmployee(request.getEmployee());
        discharge.setTotal(request.getTotal());
        inventoryBean.persistDischarge(discharge);

        for(ProductDischargeRequest x: request.getProductDischarges())
        {
            ProductDischarge productDischarge = new ProductDischarge();
            productDischarge.setDischarge(discharge.getId());
            productDischarge.setProduct(x.getProduct());
            productDischarge.setPrice(x.getPrice());
            productDischarge.setQuantity(x.getQuantity());
            inventoryBean.persistProductDischarge(productDischarge);
        }


        return discharge;
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

    @GET
    @Path("/products")
    @Secured
    public List<Product> allProducts()
    {
        return inventoryBean.allProducts();
    }

    @GET
    @Path("/discharge/details/{dischargeId}")
    @Secured
    public List<DischargeDetailsResponse> getDischargeDetails(@PathParam("dischargeId") long dischargeId)
    {
        List<ProductDischarge> productDischarges = inventoryBean.productDischargesByDischarge(dischargeId);
        List<DischargeDetailsResponse> responses = new ArrayList<>();

        for(ProductDischarge x: productDischarges)
        {
            Product product = inventoryBean.productById(x.getProduct());
            DischargeDetailsResponse y = new DischargeDetailsResponse();
            y.setProductDischarge(x);
            y.setProduct(product);
            responses.add(y);
        }

        return responses;

    }




}
