package oop.design.patterns.dzone.behavioral.strategy;

import java.io.File;
import java.util.ArrayList;

//Strategy Interface
public interface CompressionStrategy {

    public void compressFiles(ArrayList<File> files);
}
