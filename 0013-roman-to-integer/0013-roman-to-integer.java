class Solution {

    public int value(char ch) {
        if (ch == 'I') return 1;
        else if (ch == 'V') return 5;
        else if (ch == 'X') return 10;
        else if (ch == 'L') return 50;
        else if (ch == 'C') return 100;
        else if (ch == 'D') return 500;
        else return 1000; // M
    }

    public int romanToInt(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int curr = value(s.charAt(i));

            // Agar next character exist karta hai aur uski value badi hai
            if (i < s.length() - 1 && curr < value(s.charAt(i + 1))) {
                ans = ans - curr;
            } else {
                ans = ans + curr;
            }
        }

        return ans;
    }
}
