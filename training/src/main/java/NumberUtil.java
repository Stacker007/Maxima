public class NumberUtil {
    public boolean isSimple(int number) {
        if (number <= 1) {
            throw new IncorrectException();
        }

        if (number == 2 || number == 3) {
            return true;
        }

        for (int i = 4; i < number; i++) {
            if (number % i == 0) {
                return false;

            }
        }
        return true;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
