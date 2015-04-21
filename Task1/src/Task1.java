/**
 * Created by tutunkova on 21.04.2015.
 */
public class Task1 {

    public static long getBit(long N, int p)
    {
        return (N >> p) & 1;
    }

    public static void main(String[] args) {
        long a = Long.parseLong(args[0]);
        long b;
        int count = 0;


        for (int i=0; i!=64; i++){
            b = getBit(a, i);
            if (b == 1){
                count ++;
            }
        }
        System.out.println(count);
    }
}
