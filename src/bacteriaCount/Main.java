package bacteriaCount;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] bacteria = {13, 6, 1};
        int turn = 0;

        System.out.println(Arrays.toString(bacteria));
        while (!healthy(bacteria)) {
            bacteria = takeDose(bacteria);
            System.out.println(Arrays.toString(bacteria));
            ++turn;
            bacteria = reproduce(bacteria);
        }

        System.out.printf("It took %d turns to remove the infection.", turn);

    }

    private static boolean healthy(int[] bacteria) {
        return bacteria[0] == 0 && bacteria[1] == bacteria[0] && bacteria[2] == bacteria[1];
    }

    private static int[] takeDose (int[] bacteria) {
        int roll = (int) (Math.random() * 6) + 1;
        int toRemove = 5;
        if (roll == 2 || roll == 4)
            return bacteria;
        else {
            for (int i = 0; i < bacteria.length; ++i) {
                if (bacteria[i] - toRemove > 0) {
                    bacteria[i] -= toRemove;
                    return bacteria;
                } else {
                    if (bacteria[i] <= 0)
                        ++i;
                    toRemove -= bacteria[i];
                    bacteria[i] = 0;
                    }
                }
            }

        // If this return is called when more than
        // 5 cells, remain something is broken.
        System.out.println("The last return in take dose was called.");
        return bacteria;
    }

    private static int[] reproduce(int[] bacteria) {
        for (int i = 0; i < bacteria.length; ++i) {
            if (bacteria[i] > 0)
                ++bacteria[i];
        }
        return bacteria;
    }

}
