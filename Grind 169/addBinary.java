class Solution {
    public String addBinary(String a, String b) {
        int alen = a.length(), blen = b.length();
        StringBuilder ans = new StringBuilder();
        boolean carry = false;
        while (alen > 0 || blen > 0) {
            char curA = alen < 1 ? '0' : a.charAt(alen - 1);
            char curB = blen < 1 ? '0' : b.charAt(blen - 1);
            if (curA == curB) {
                ans.append(carry ? '1' : '0');
                carry = (curA == '1') ? true : false;
            } else {
                if (carry) {
                    ans.append('0');
                } else {
                    ans.append('1');
                    carry = false;
                }
            }
            alen--;
            blen--;
        }
        if (carry)
            ans.append('1');
        return ans.reverse().toString();
    }
}