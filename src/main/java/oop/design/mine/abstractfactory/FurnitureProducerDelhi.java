package oop.design.mine.abstractfactory;


import oop.design.mine.abstractfactory.model.Chair;
import oop.design.mine.abstractfactory.model.Furniture;
import oop.design.mine.abstractfactory.model.Table;

public class FurnitureProducerDelhi extends AbstractProducer {

	@Override
	public Furniture createFurniture(String type) {
		AbstractMaterialFactory factory = new MaterialFactoryForDelhi();
		Furniture furniture = null;
		if ("CHAIR".equals(type))
			furniture = new Chair("Delhi Chair", factory);
		else if ("TABLE".equals(type))
			furniture = new Table("Delhi Table", factory);
		return furniture;
	}
}
