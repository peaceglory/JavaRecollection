package oop.design.patterns.codegeeks.creational.abstractfactory;

/**
 * <p>
 * <b>Type: Creational</b>
 * </p>
 *
 * <p>
 * <b>Intent:</b><br />
 * Enables clients to create families of related objects without the need to know which classes need to be instantiated.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * Hides implementation details - clients are only aware of interfaces.
 * </p>
 *
 * <p>
 * <b>Downs:</b>
 * <ul>
 * <li>If it is not actually needed it adds complexity.</li>
 * <li>The exact factory to be used is sometimes determined at runtime with some if/else statements (although that's not always the case).</li>
 * </ul>
 * </p>
 */
public class TestAbstractFactoryPattern {

	public static void main(String[] args) {
		
		AbstractParserFactory parserFactory = ParserFactoryProducer.getFactory("NYFactory");
		XMLParser parser = parserFactory.getParserInstance("NYORDER");
		String msg="";
		msg = parser.parse();
		System.out.println(msg);
		
		System.out.println("************************************");
		
		parserFactory = ParserFactoryProducer.getFactory("TWFactory");
		parser = parserFactory.getParserInstance("TWFEEDBACK");
		msg = parser.parse();
		System.out.println(msg);
	}

}
