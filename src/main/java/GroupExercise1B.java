import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created 2019-09-30 by patrikingverud
 */
public class GroupExercise1B {

    private static final int SAMPLE_SIZE = 200000;
    private static final int D = SAMPLE_SIZE/1000;
    private static final int PROBABILITY = 10;

    public static void main(String args[]) {
        int count = 0;

        Random random = new Random();
        int[] integers = new int[SAMPLE_SIZE];
        int var;

        for (int i = 0; i < SAMPLE_SIZE; i++) {
            var = random.nextInt(PROBABILITY);
            if (var == 0) {
                integers[i] = 1;
                count++;
            } else {
                integers[i] = 0;
            }
        }
        //print the answer
        System.out.println("count: " + count);
        System.out.flush();


        int num = getNum(random, integers);
        float prob = ((float) num/(D));
        System.out.println("Probability: " + prob);
        System.out.println("Percentage: " + (Math.pow((double)prob, (double)1/(PROBABILITY))));
        System.out.println("NUM: " + num);
    }

    private static int getNum(Random random, int[] integers) {
        int num = 0;
        int count;
        int var;
        for (int j = 0; j < D; j++) {
            count = 0;
            for (int i = 0; i < PROBABILITY; i++) {

                var = random.nextInt(SAMPLE_SIZE);
                if (integers[var] != 1) {
                    count++;
                }
            }
            if (count == PROBABILITY) {
                num++;
            }
            System.out.println("count: " + count);
        }
        return num;
    }
}
