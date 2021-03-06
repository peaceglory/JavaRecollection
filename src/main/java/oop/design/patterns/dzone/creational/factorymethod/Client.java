package oop.design.patterns.dzone.creational.factorymethod;


/**
 * <p>
 * <b>Type: Creational</b>
 * </p>
 *
 * <p>
 * <b>Intent:</b><br />
 * Relives clients of a service from knowing which class they need to instantiate.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * The client needs to be aware of only the service interface but remain agnostic which of the extending classes
 * would do the job.
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * If it is not actually needed it brings unnecessary complexity.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * Iterators in JDK, Different loggers, Different XML parsers.
 * </p>
 */
public class Client {

    private void someMethodThatLogs(AbstractLoggerCreator logCreator) {
        Logger logger = logCreator.createLogger();
        logger.log("message");
    }

    public static void main(String[] args) {
        //for the purposes of this example, create an XMLLoggerCreator directly,
        // but this would normally be passed to constructor for use.
        AbstractLoggerCreator creator = new XMLLoggerCreator();
        Client client = new Client();
        client.someMethodThatLogs(creator);
    }
}
