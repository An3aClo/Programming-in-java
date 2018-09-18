package multipletable;

public class MultipleTable {

    public static void main(String[] args) {
        
        int num = 1;
        for (int x = 1; x <13; x++) {
            for (int n = 1; n <13; n++) {
                System.out.print(n * num + " ");

            }
            System.out.println();
            num = num + 1;

        }
    }

}
