package oop.design.mine.abstractfactory.client;


import oop.design.mine.abstractfactory.AbstractProducer;
import oop.design.mine.abstractfactory.FurnitureProducerMumbai;
import oop.design.mine.abstractfactory.model.Furniture;

// Taken from http://techieme.in/abstract-factory-pattern/
public class ClientShopMumbai {
	public static void main(String[] args) {
		AbstractProducer producer = new FurnitureProducerMumbai();
		Furniture chair = producer.orderFurniture("CHAIR");
		System.out.println("Got chair delivered :" + chair);
	}
}
