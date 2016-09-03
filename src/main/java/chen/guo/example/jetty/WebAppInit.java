package chen.guo.example.jetty;

import chen.guo.example.rest.MyResource;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/chen")
public class WebAppInit extends ResourceConfig {

  public WebAppInit() {
    super(MyResource.class, MultiPartFeature.class);
  }
}
