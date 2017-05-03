package oop.atm;

/**
 * Created by mman on 19.02.17.
 */
public class CardReader {
    private BankCard bankCard;

    public boolean insertCard(BankCard bankCard) {
        this.bankCard = bankCard;
        return true;
    }

    public boolean releaseCard() {
        this.bankCard = null;
        return true;
    }
}
