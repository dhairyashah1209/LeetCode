class Solution {

    class Roman {
        Integer priority;
        Integer value;

        Roman(int priority, int value) {
            this.priority = priority;
            this.value = value;
        }
    }

    public void insertRomanValues(HashMap<Character, Roman> romanValue) {
        romanValue.put('M', new Roman(7, 1000));
        romanValue.put('D', new Roman(6, 500));
        romanValue.put('C', new Roman(5, 100));
        romanValue.put('L', new Roman(4, 50));
        romanValue.put('X', new Roman(3, 10));
        romanValue.put('V', new Roman(2, 5));
        romanValue.put('I', new Roman(1, 1));
    }

    public int romanToInt(String s) {
        HashMap<Character, Roman> romanValue = new HashMap<>();
        insertRomanValues(romanValue);

        int n = s.length(), i = 0;
        int ans = 0;

        while (i < n) {
            Roman cur = romanValue.get(s.charAt(i));
            while (i + 1 < n && romanValue.get(s.charAt(i + 1)).priority > cur.priority) {
                ans -= cur.value;
                cur = romanValue.get(s.charAt(i + 1));
                i++;
            }
            ans += cur.value;
            i++;
        }

        return ans;
    }
}