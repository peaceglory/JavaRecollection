package oop.design.patterns.mine.abstractfactory.client;

import oop.design.patterns.mine.abstractfactory.AbstractProducer;
import oop.design.patterns.mine.abstractfactory.FurnitureProducerDelhi;
import oop.design.patterns.mine.abstractfactory.model.Furniture;

// Taken from http://techieme.in/abstract-factory-pattern/
public class ClientShopDelhi {
	public static void main(String[] args) {
		AbstractProducer producer = new FurnitureProducerDelhi();
		Furniture chair = producer.orderFurniture("CHAIR");
		System.out.println("Got chair delivered :" + chair.toString());
	}
}
