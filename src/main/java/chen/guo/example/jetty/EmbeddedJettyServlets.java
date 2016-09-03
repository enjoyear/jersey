package chen.guo.example.jetty;

import chen.guo.example.jetty.servlet.ExampleServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class EmbeddedJettyServlets {
  public static void main(String[] args) throws Exception {

    Server server = new Server(8080);
    ServletContextHandler sch = new ServletContextHandler(server, "/chen");
    sch.addServlet(ExampleServlet.class, "/relativepath");

    ResourceHandler rh = new ResourceHandler();
    rh.setResourceBase("./src/webcontent");

    server.start();
    server.join();
  }
}
