package PemesananMakanan.Controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import PemesananMakanan.Common.User;
import PemesananMakanan.Service.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @POST
    public Response createUser(User user) {
        try {
            
            setRoleKode(user);

           
            User createdUser = userService.createUser(user);

            return Response.status(Response.Status.CREATED).entity(createdUser).build();
        } catch (Exception e) {
            
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error creating user").build();
        }
    }

    
    private void setRoleKode(User user) {
        String email = (String) user.getEmail();
        if (email.endsWith("@gmail.com") || email.endsWith("@yahoo.co.id") || email.endsWith("@hotmail.com")) {
            
            user.setRoleKode("PM");
        } else {
           
            user.setRoleKode("YOUR_DESIRED_ROLE_CODE");
        }
    }

    @GET
    @Path("/profile/{userId}")
    public Response getProfileUser(@PathParam("userId") String userId) {
        try {
            User user = userService.getUserById(userId);
            if (user != null) {
                return Response.status(Response.Status.OK).entity(user).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
            }
        } catch (Exception e) {
            
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving user").build();
        }
    }

    @DELETE
    @Path("/delete/{userId}")
    public Response deleteUser(@PathParam("userId") String userId) {
        try {
            userService.deleteUser(userId);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error deleting user").build();
        }
    }

    @PUT
    @Path("/update/{userId}")
    public Response updateUser(@PathParam("userId") String userId, User updatedUser) {
        try {
            User existingUser = userService.getUserById(userId);
            if (existingUser != null) {
               
                existingUser.setName(updatedUser.getName());
                existingUser.setEmail(updatedUser.getEmail());
               

                userService.updateUser(existingUser);

                return Response.status(Response.Status.OK).entity(existingUser).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
            }
        } catch (Exception e) {
            
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error updating user").build();
        }
    }
}

