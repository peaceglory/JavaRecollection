package oop.design.mine.abstractfactory;


import oop.design.mine.abstractfactory.model.*;

public class MaterialFactoryForDelhi implements AbstractMaterialFactory {

	@Override
	public Wood getWood() {
		return new TeakWood();
	}

	@Override
	public Nail getNail() {
		return new CopperNail();
	}

	@Override
	public Glue getGlue() {
		return new YellowWoodGlue();
	}

}
