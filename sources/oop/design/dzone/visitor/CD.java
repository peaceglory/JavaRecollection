package sources.oop.design.dzone.visitor;

/**
 * Created by mman on 16.01.17.
 */
public class CD implements Visitable {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
