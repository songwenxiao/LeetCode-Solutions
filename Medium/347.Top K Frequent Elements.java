public class Solution {
    public List<Integer> topKFrequent1(int[] nums, int k) {
        // Priority Queue's size is k, hence the run time for this case is just O(lgK).
        PriorityQueue<Map.Entry<Integer, Integer>> kFrequent = new PriorityQueue<>(k,
                                                                                   // override Comprator class 
                                                                                   new Comparator<Map.Entry<Integer, Integer>>() {
                                                                                      public int compare(Map.Entry<Integer, Integer> left, Map.Entry<Integer, Integer>right){
                                                                                           return right.getValue().compareTo(left.getValue());
                                                                                       }
                                                                                   }
                                                                                   );
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.putIfAbsent(num, 0);
           // if key is already in the map, then increase the counter
            map.computeIfPresent(num, (key, oldVal) -> oldVal + 1);
        }
        //use priority queue to find kFrequent
        for(Map.Entry<Integer, Integer> mapEntry : map.entrySet()){
            kFrequent.offer(mapEntry);
        }
        List<Integer> returnList = new ArrayList<>();
        for(int i = 0; i < k; i++){
            // in practice, we need check operation is null or not
            //System.out.println(kFrequent.poll());
            returnList.add(kFrequent.poll().getKey());
        }
        return returnList;
    }
    //bucket sort
    public List<Integer> topKFrequent2(int[] nums, int k) {
      List<Integer>[] bucket = new List[nums.length + 1];
    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

    for (int n : nums) {
        frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
    }

    for (int key : frequencyMap.keySet()) {
        int frequency = frequencyMap.get(key);
        if (bucket[frequency] == null) {
            bucket[frequency] = new ArrayList<>();
        }
        bucket[frequency].add(key);
    }

    List<Integer> res = new ArrayList<>();

    for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
        if (bucket[pos] != null) {
            res.addAll(bucket[pos]);
        }
    }
    return res;
    }
}