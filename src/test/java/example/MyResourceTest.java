package example;

import org.glassfish.grizzly.http.server.HttpServer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertEquals;

public class MyResourceTest {
  private HttpServer server;
  private WebTarget target;

  @org.junit.Before
  public void setUp() throws Exception {
    server = Main.startServer();

    Client c = ClientBuilder.newClient();
    target = c.target(Main.BASE_URI);
  }

  @org.junit.After
  public void tearDown() throws Exception {
    server.shutdownNow();
  }

  @org.junit.Test
  public void getIt() {
    String responseMsg = target.path("myresource").request().get(String.class);
    assertEquals("Got it!", responseMsg);
  }
}
