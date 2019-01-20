package sample;

public class Constants {

    public static String WORKER_AUTH_TOKEN = "";
    public static String CLIENT_AUTH_TOKEN = "";
    public static ClientProfile client;
    public static Bank bank;

    public ClientProfile getClient() {
        return client;
    }

    public void setClient(ClientProfile client) {
        this.client = client;
    }

    public static Bank getBank() {
        return bank;
    }

    public static void setBank(Bank bank) {
        Constants.bank = bank;
    }
}
