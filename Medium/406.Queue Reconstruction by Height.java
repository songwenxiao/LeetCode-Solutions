public class Solution {
    class PairComp implements Comparator<int[]> {
        public int compare(int[] p1, int[] p2){
            int comp_h = Integer.compare(p2[0], p1[0]);
            return comp_h == 0 ? Integer.compare(p1[1], p2[1]): comp_h;
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        LinkedList<int[]> list = new LinkedList();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(1, new PairComp() );
        for (int[] ppl: people){
            queue.offer( ppl );
        }
        while ( ! queue.isEmpty() ) {
            int[] pair = queue.poll();
            list.add(pair[1], pair);
        }
        int[][] ret = new int[people.length][];
        for (int i=0; i<list.size(); i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int n = people.length;
        int[][] ret = new int[n][];
        for (int i = 0; i < n; i++) {
            for (int j = 0, ahead = 0; j < n; j++) {
                if (ahead < people[i][1]) {
                    ahead += (ret[j] == null || ret[j][0] >= people[i][0]) ? 1 : 0;
                } else if (ret[j] == null) {
                    ret[j] = people[i];
                    break;
                }
            }
        }
        return ret;
    }
}