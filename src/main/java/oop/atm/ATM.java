package oop.atm;

import oop.atm.enums.Languages;

/**
 * Created by mman on 19.02.17.
 */
public class ATM {
    private final CardReader cardReader;
    private final Console console;
    private final CashStorage cashStorage;
    private final Printer printer;
    private final Network network;

    public ATM(Network network) {
        this.network = network;
        this.cardReader = new CardReader();
        this.console = new Console();
        this.cashStorage = new CashStorage();
        this.printer = new Printer();

        setObservableSubjects();
    }

    public void cardPlugged(BankCard bankCard) {

    }

    public void selectLanguage(Languages language) {

    }

    public void executeOperation(Operation operation) {

    }

    private void setObservableSubjects() {

    }
}
