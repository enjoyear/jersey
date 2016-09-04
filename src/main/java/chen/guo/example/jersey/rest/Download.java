package chen.guo.example.jersey.rest;

import chen.guo.example.jersey.service.DownloadService;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Path("home")
public class Download {

  private DownloadService downloadService = new DownloadService();

  @GET
  @Path("download")
  @Produces(MediaType.TEXT_HTML)
  public InputStream doGet() throws FileNotFoundException {
    //http://localhost:8080/home/download
    File f = new File("src/webcontent/download.html");
    return new FileInputStream(f);
  }

  @POST
  @Path("download")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public Response uploadDownload(@FormParam("name") String name) {
    //curl --data "name=hi,there" localhost:8080/home/download
    System.out.println("download");
    StreamingOutput stream = os -> {
      downloadService.download(os, name);
    };
    //String mediaType = download != null ? "text/csv" : MediaType.TEXT_PLAIN;
    return Response.ok(stream, "text/csv").build();
  }
}
