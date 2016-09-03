package chen.guo.example.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class EmbeddedJettyApp {
  public static void main(String[] args) throws Exception {

    Server server = new Server(8080);
    ServletContextHandler sch = new ServletContextHandler(server, "/chen");
    ServletHolder jerseyServlet = sch.addServlet(ServletContainer.class, "/*");
    jerseyServlet.setInitOrder(0);
    jerseyServlet.setInitParameter("javax.ws.rs.Application", "chen.guo.example.jetty.WebAppInit");


    ResourceHandler rh = new ResourceHandler();
    rh.setResourceBase("./src/webcontent");

    server.start();
    server.join();
  }
}
