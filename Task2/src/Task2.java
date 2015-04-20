/**
 * Created by tutunkova on 17.04.2015.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class Task2 {
    public static byte[] longToBytes(long l) {
        byte[] result = new byte[8];
        for (int i = 7; i >= 0; i--) {
            result[i] = (byte) (l & 0xFF);
            l>>= 8;
        }
        return result;
    }

    public static long bytesToLong(byte[] b) {
        long result = 0;
        for (int i = 0; i < 8; i++) {
            result<<= 8;
            result |= (b[i] & 0xFF);
        }
        return result;
    }
    public static byte[] getBytesFromFile(File file) throws IOException{

        FileInputStream is = new FileInputStream(file);

        long length = file.length();

        byte[] bytes = new byte[(int)length];

        is.read(bytes, 0, bytes.length);

        is.close();
        String a = file.getName();

        return bytes;

    }

    public static void main(String[] args) {
        int z = 0;
        int indx = 0;
        int ind2 = 0;
        int k = args.length-1;
        long[] myArr = new long[k];
        byte[] myArr1 = new byte[k * 8];
        byte[] myArr2 = new byte[k * 8];
        long[] myArr3 = new long[k * 9];

        FileOutputStream wr = null;
        File file1 = new File(args[0]);

        for (int i = 0; i != k; i++) {
            myArr[i] = Long.parseLong(args[i+1]);
        }

        for (int m = 0; m != k; m++) {
            byte[] result = longToBytes(myArr[m]);

            for (int ind = 0; ind != 8; ind++) {
                myArr2[z] = result[ind];
                z++;
            }

        }
/* for (int j=0; j!=8*k; j++) {
myArr1[j] = (byte)myArr2[j];
}*/
        try {

            wr = new FileOutputStream(file1);

            if (!file1.exists()) {
                file1.createNewFile();
            }

            wr.write(myArr2);
            wr.flush();
            wr.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myArr1 = getBytesFromFile(file1);
        }catch (IOException e) {
            e.printStackTrace();
        }

        for (int l = 0; l != k; l++) {
            byte[] myArr4;
            myArr4 = new byte[8];
            for (int s = 0; s != 8; s++) {

                myArr4[s] = myArr1[ind2];
                ind2++;
            }

            long result = bytesToLong(myArr4);

            myArr3[indx] = result;
            indx++;

        }

        for (int n = 0; n != k; n++) {
            System.out.println(myArr3[n]);
        }
    }
}