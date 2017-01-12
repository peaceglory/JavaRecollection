package sources.oop.design.mine.abstractfactory;


import sources.oop.design.mine.abstractfactory.model.Glue;
import sources.oop.design.mine.abstractfactory.model.Nail;
import sources.oop.design.mine.abstractfactory.model.Wood;

public interface AbstractMaterialFactory {
	public Wood getWood();

	public Nail getNail();

	public Glue getGlue();
}
