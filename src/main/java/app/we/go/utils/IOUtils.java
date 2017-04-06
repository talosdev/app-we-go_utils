package app.we.go.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {

    private IOUtils() {
        // Private constructor for util class
    }

    /**
     * Copies an {@link InputStream} to an {@link OutputStream}, using a default <code>buffersize</code> of 1024.
     * @param is
     * @param os
     * @throws IOException
     */
    public static void copyInputStreamToOutputStream(InputStream is, OutputStream os) throws IOException {
        copyInputStreamToOutputStream(is, os, 1024);
    }

    /**
     * Copies an {@link InputStream} to an {@link OutputStream}, using the specified size for the buffer
     * @param is
     * @param os
     * @param bufferSize
     * @throws IOException
     */
    public static void copyInputStreamToOutputStream(InputStream is, OutputStream os, int bufferSize) throws IOException {
        byte[] buf = new byte[bufferSize];
        int len;
        while ((len = is.read(buf)) > 0) {
            os.write(buf, 0, len);
        }
    }
}
