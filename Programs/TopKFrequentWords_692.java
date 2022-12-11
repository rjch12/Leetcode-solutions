import java.util.*;

class TopKFrequentWords_692 {
    class Node {
        String word;
        int freq;

        public Node(String w, int f) {
            this.word = w;
            this.freq = f;
        }
    }

    public static void main(String[] args) {
        TopKFrequentWords_692 t = new TopKFrequentWords_692();
        System.out.println(t.topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
    }

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq)
                return b.word.compareTo(a.word);
            else
                return a.freq - b.freq;
        });
        Map<String, Integer> hm = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }

        for (String key : hm.keySet()) {
            pq.offer(new Node(key, hm.get(key)));
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().word);
            res.add(pq.poll().word);
        }
        return res;
    }
}