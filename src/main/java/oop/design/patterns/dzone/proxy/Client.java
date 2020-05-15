package oop.design.patterns.dzone.proxy;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * <p>
 * <b>Type: Structural</b>
 * </p>
 * <p>
 * <b>Intent:</b><br />
 * Handles responsibility of managing access to an object to another object.
 * </p>
 *
 * <p>
 * <b>Ups:</b>
 * <ul>
 * <li>The proxy can provide access to a remote object.</li>
 * <li>The proxy can provide security checks before letting the call.</li>
 * <li>The proxy can add functionality before/after the real call.</li>
 * <li>The proxy can provide lazy-loading of big data.</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * Can be misused especially at #4 (see above).
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * RMI, Servlet
 * </p>
 */
public class Client {

    public static void main(String[] args) throws MalformedURLException {
        Image largeImage = new ProxyImage(new URL("www.google.com"));
        largeImage.displayImage();
    }
}
