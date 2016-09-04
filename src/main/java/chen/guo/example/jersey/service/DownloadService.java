package chen.guo.example.jersey.service;


import java.io.IOException;
import java.io.OutputStream;

public class DownloadService {
  public void download(OutputStream os, String s) throws IOException {
    os.write(s.getBytes());
  }
}
