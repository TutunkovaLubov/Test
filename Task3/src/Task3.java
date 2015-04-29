/**
 * Created by tutunkova on 28.04.2015.
 */


public class Task3 {

    public static int fibRec(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return (fibRec(n - 1) + fibRec(n - 2));
    }

    public static void main(String[] args) {
        if (args == null || args.length < 2) {
            System.out.println("Аргументы отсутствуют или введены некорректно");
            return;
        } else {

            String s = args[0];
            int N = Integer.parseInt(args[1]);

            if (s.equals("fibo")) {

                if (N >= 0) {
                    for (int i = 1; fibRec(i) <= N; i++) {
                        System.out.print(fibRec(i) + " ");
                    }
                } else {
                    for (int i = 1; (fibRec(i + 1) * (-1)) >= N; i++) {
                        if (i == 1) {
                            System.out.print(fibRec(i) + " ");
                        }
                        System.out.print(fibRec(i + 1) * (-1) + " ");
                    }
                }
            } else
                if (s.equals("prime")) {
                    if(N<=1){
                        System.out.println("Вы ввели некорректные аргументы");
                        return;
                    }
                    int a, b;

                    if (N >= 2) {
                        System.out.print("2" + " ");
                    }
                    for (a = 3; a <= N; a += 2) {
                    b = 0;
                        for (int i = 1; i <= a / 2; i++) {
                            if (a % i == 0)
                                b++;
                        }
                        if (b <= 1)
                            System.out.print(a + " ");
                    }
                }
                else
                    System.out.println("Вы ввели некорректные аргументы, не соответствующие условиям задачи");
        }
    }
}

