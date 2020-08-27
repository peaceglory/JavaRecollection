package oop.design.patterns.codegeeks.behavioral.command;

/**
 * <p>
 * <b>Type: Behavioral</b>
 * </p>
 *
 * <p>
 * <b>Intent:</b><br />
 * Encapsulates a client's request into an object allowing it to be handled when the time is appropriate.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * 1. Allows for callback functionality.<br />
 * 2. Allows for history of requests. <br />
 * 3. Decouples task invoker from the concrete object that knows what to do.
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * Every command needs a separate class.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * Job queue, Remote control.
 * </p>
 */
public class TestCommandPattern {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
        ThreadPool pool = new ThreadPool(10);

        Email email = null;
        EmailJob emailJob = new EmailJob();

        Sms sms = null;
        SmsJob smsJob = new SmsJob();

        FileIO fileIO = null;
        FileIOJob fileIOJob = new FileIOJob();

        Logging logging = null;
        LoggingJob logJob = new LoggingJob();

        for (int i = 0; i < 5; i++) {
            email = new Email();
            emailJob.setEmail(email);

            sms = new Sms();
            smsJob.setSms(sms);

            fileIO = new FileIO();
            fileIOJob.setFileIO(fileIO);

            logging = new Logging();
            logJob.setLogging(logging);

            pool.addJob(emailJob);
            pool.addJob(smsJob);
            pool.addJob(fileIOJob);
            pool.addJob(logJob);
        }
        pool.shutdownPool();
    }

}
