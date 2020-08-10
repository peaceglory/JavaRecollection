package oop.design.patterns.dzone.behavioral.templatemethod;

public class IPhoneCompiler extends CrossCompiler {

    protected void collectSource() {
        //anything specific to this class
    }

    protected void compileToTarget() {
        //iphone specific compilation
    }
}
