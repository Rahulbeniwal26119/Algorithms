public class MaxSubstringLength {

    // complexity is O(n**3)
    public static int maxSubstringLength(String s) {
        int length = s.length();
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j += 2) {
                int len = j - i + 1;
                if (maxLength >= len)
                    continue;
                int lSum = 0;
                int rSum = 0;

                for (int k = i; k < len / 2; k++) {
                    lSum += s.charAt(k) - '0';
                    rSum += s.charAt(length / 2 + k) - '0';
                }

                if (lSum == rSum) {
                    maxLength = len;
                }
            }
        }
        return maxLength;
    }

    public static void main(String... args) {
        String s = "944728";
        System.out.println(maxSubstringLength(s));
    }
}
