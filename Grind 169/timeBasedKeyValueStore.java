class Data {
    String val;
    int time;

    Data(String val, int time) {
        this.val = val;
        this.time = time;
    }
}

class TimeMap {
    Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<String, List<Data>>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        return binarySearch(map.get(key), timestamp);
    }

    private String binarySearch(List<Data> list, int timestamp) {
        int left = 0, right = list.size() - 1;
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int curTime = list.get(mid).time;
            if (curTime == timestamp)
                return list.get(mid).val;
            else if (list.get(mid).time >= timestamp)
                right = mid - 1;
            else {
                result = list.get(left).val;
                left = mid + 1;
            }
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */