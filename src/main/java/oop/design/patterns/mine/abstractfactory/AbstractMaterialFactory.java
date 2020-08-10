package oop.design.patterns.mine.abstractfactory;


import oop.design.patterns.mine.abstractfactory.model.Glue;
import oop.design.patterns.mine.abstractfactory.model.Nail;
import oop.design.patterns.mine.abstractfactory.model.Wood;

public interface AbstractMaterialFactory {
	public Wood getWood();

	public Nail getNail();

	public Glue getGlue();
}
