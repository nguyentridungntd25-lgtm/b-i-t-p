public class Ex5_2 {
    public static void main(String[] args) {
        int n = 100000;
        long startString = System.currentTimeMillis();
        String str = "Hello";
        for (int i =0; i <n; i++) {
            str =str + " World";
        }
        long endString = System.currentTimeMillis();
        System.out.println("Thời gian nối chuỗi bằng String: " +(endString - startString) + " ms");
        long startBuilder = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder("Hello");
        for (int i = 0; i < n; i++) {
            sb.append(" World");
        }
        long endBuilder =System.currentTimeMillis();
        System.out.println("Thời gian nối chuỗi bằng StringBuilder: "+ (endBuilder - startBuilder) + " ms");
        long startBuffer = System.currentTimeMillis();
        StringBuffer sbf= new StringBuffer("Hello");
        for (int i = 0; i < n; i++) {
            sbf.append(" World");
        }
        long endBuffer = System.currentTimeMillis();
        System.out.println("Thời gian nối chuỗi bằng StringBuffer: " + (endBuffer - startBuffer) + " ms");
    }
}
