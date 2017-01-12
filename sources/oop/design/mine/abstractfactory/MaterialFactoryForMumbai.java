package sources.oop.design.mine.abstractfactory;


import sources.oop.design.mine.abstractfactory.model.*;

public class MaterialFactoryForMumbai implements AbstractMaterialFactory {

	@Override
	public Wood getWood() {
		return new MahoganyWood();
	}

	@Override
	public Nail getNail() {
		return new IronNail();
	}

	@Override
	public Glue getGlue() {
		return new WhiteCraftGlue();
	}

}
