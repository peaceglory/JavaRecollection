package oop.design.patterns.dzone.structural.proxy;

import java.net.URL;

public class ProxyImage implements Image {
    private Image realImage;
    private URL url;

    public ProxyImage(URL url) {
        this.url = url;
    }

    //this method delegates to the real image
    public void displayImage() {
        if (realImage == null) {
            realImage = new RealImage(url);
        }
        realImage.displayImage();
    }
}
