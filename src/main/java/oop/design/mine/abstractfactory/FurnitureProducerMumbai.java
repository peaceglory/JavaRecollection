package oop.design.mine.abstractfactory;


import oop.design.mine.abstractfactory.model.Chair;
import oop.design.mine.abstractfactory.model.Furniture;
import oop.design.mine.abstractfactory.model.Table;

public class FurnitureProducerMumbai extends AbstractProducer {

	@Override
	public Furniture createFurniture(String type) {
		AbstractMaterialFactory factory = new MaterialFactoryForMumbai();
		Furniture furniture = null;
		if ("CHAIR".equals(type))
			furniture = new Chair("Mumbai Chair", factory);
		else if ("TABLE".equals(type))
			furniture = new Table("Mumbai Table", factory);
		return furniture;
	}
}
