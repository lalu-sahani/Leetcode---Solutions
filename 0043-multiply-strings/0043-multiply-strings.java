class Solution {
    public String multiply(String num1, String num2) {

        // Agar kisi ek number ka value 0 hai
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n = num1.length();
        int m = num2.length();

        // Result array
        int[] result = new int[n + m];

        // Last digit se multiplication
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;

                // Position
                int p1 = i + j;
                int p2 = i + j + 1;

                // Pehle se stored value bhi add hogi
                int sum = product + result[p2];

                // Ones digit
                result[p2] = sum % 10;

                // Carry
                result[p1] += sum / 10;
            }
        }

        // Array ko String me convert karo
        StringBuilder ans = new StringBuilder();

        for (int num : result) {
            // Leading zero skip karo
            if (!(ans.length() == 0 && num == 0)) {
                ans.append(num);
            }
        }

        return ans.toString();
    }
}