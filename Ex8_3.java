package ra.edu;

class CurrencyConverter {
    private static double rate;
    public static void setRate(double r) {
        if (r > 0) {
            rate = r;
        } else {
            System.out.println("Ti gia khong hop le");
        }
    }

    public static double getRate() {
        return rate;
    }

    public static double toUSD(int vnd) {
        return vnd / rate;
    }
    public static String formatUSD(double usd) {
        return String.format("%.2f USD", usd);
    }
}
public class Ex8_3 {
    public static void main(String[] args) {
        CurrencyConverter.setRate(25000);
        int vnd = 500000;
        double usd = CurrencyConverter.toUSD(vnd);
        System.out.println("VND: " + vnd);
        System.out.println("USD: " + CurrencyConverter.formatUSD(usd));
    }
}