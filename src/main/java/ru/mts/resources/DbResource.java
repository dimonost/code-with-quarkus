package ru.mts.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ru.mts.entity.JustUser;
import ru.mts.repository.JustUserRepository;

import java.util.List;

@Path("/db")
public class DbResource {
    @Inject
    JustUserRepository justUserRepository;

    @Path("/users")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<JustUser> users() {
        return justUserRepository.listAll();
    }
}
