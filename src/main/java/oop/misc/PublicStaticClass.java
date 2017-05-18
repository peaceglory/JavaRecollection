package oop.misc;

/**
 * Created by mman on 18.05.17.
 */
public class PublicStaticClass {

    public PublicStaticClass() {
        OnlyInternalClassesAreCanBeStatic o = new OnlyInternalClassesAreCanBeStatic();
        o.some();
    }

    private static class OnlyInternalClassesAreCanBeStatic {

        private void some() {

        }

    }
}
