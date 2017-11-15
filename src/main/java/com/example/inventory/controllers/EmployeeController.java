package com.example.inventory.controllers;

import com.example.common.validators.auth.user.AuthenticatedUser;
import com.example.common.validators.auth.user.Secured;
import com.example.inventory.beans.EmployeeBean;
import com.example.inventory.controllers.request.EmployeeRequest;
import com.example.inventory.models.Employee;
import com.example.users.beans.UserBean;
import com.example.users.models.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeController {

    @EJB
    EmployeeBean employeeBean;

    @EJB
    UserBean userBean;

    @Inject
    @AuthenticatedUser
    User user;

    @GET
    @Path("/all")
    @Secured
    public List<Employee> allEmployees()
    {
        return employeeBean.all();
    }

    @POST
    @Path("/create")
    @Secured
    public Employee createEmployee(@Valid EmployeeRequest request)
    {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setUser(user.getId());
        employeeBean.persistEmployee(employee);
        return employee;
    }

}
