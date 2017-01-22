package sources.oop.design.dzone.template;

public abstract class CrossCompiler {

    public final void crossCompile() {
        collectSource();
        compileToTarget();
    }

    //Template methods
    protected abstract void collectSource();

    protected abstract void compileToTarget();
}