package oop.design.mine.abstractfactory;


import oop.design.mine.abstractfactory.model.Glue;
import oop.design.mine.abstractfactory.model.Nail;
import oop.design.mine.abstractfactory.model.Wood;

public interface AbstractMaterialFactory {
	public Wood getWood();

	public Nail getNail();

	public Glue getGlue();
}
