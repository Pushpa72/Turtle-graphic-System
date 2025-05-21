public class Diamonds {
    public static void main(String[] args) {
        int trows =7;
        int m = trows/2;

        for(int i=1;i<=m;i++){
            int space = trows-i;
            int stars = 2*i+1;

            for(int j=0;j<space;j++){
                System.out.print(" ");
            }
            for(int j=0;j<stars;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=m-1;i>=0;i--){
            int space = trows-i;
            int stars = 2*i+1;
            for(int j=0;j<space;j++){
                System.out.print(" ");
            }
            for(int j=0;j<stars;j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
