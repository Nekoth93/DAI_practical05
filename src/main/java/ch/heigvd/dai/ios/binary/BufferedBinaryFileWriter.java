package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Writable;

import java.io.*;

/**
 * A class that writes binary files. This implementation writes the file using a buffered output
 * stream. It manages the file output stream properly with a try-with-resources block.
 */
public class BufferedBinaryFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) throws IOException {
    try(OutputStream out = new FileOutputStream(filename);
        BufferedOutputStream bouts = new BufferedOutputStream(out)) {
      for(int i = 0; i < sizeInBytes; i++) {
        bouts.write(i);
      }
      bouts.flush();
    } catch (java.io.IOException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}
