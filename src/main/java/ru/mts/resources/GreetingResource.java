package ru.mts.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import net.sf.jasperreports.engine.JRException;
import ru.mts.services.JasperService;

@Path("/")
public class GreetingResource {
    @Inject
    JasperService jasperService;

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @Path("/compile")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String compile() throws JRException {
        jasperService.justCompile();
        return "Ok";
    }

    @GET
    @Path("/pdf")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response generateReport() throws JRException {
        // Sample data

        // Generate the report
        byte[] reportBytes = jasperService.getPdf();

        // Return the report as a downloadable file
        return Response.ok(reportBytes)
                .header("Content-Disposition", "attachment; filename=\"report.pdf\"")
                .build();
    }

}
