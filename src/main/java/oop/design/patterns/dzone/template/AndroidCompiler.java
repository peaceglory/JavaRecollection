package oop.design.patterns.dzone.template;

public class AndroidCompiler extends CrossCompiler {

    protected void collectSource() {
        //anything specific to this class
    }

    protected void compileToTarget() {
        //android specific compilation
    }
}
