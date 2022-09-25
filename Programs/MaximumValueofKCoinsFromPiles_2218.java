import java.util.*;

class MaximumValueofKCoinsFromPiles_2218 {
    public static void main(String[] args) {
        MaximumValueofKCoinsFromPiles_2218 m = new MaximumValueofKCoinsFromPiles_2218();
        List<List<Integer>> piles = new ArrayList<>();
        piles.add(Arrays.asList(1, 100, 3));
        piles.add(Arrays.asList(7, 8, 9));
        System.out.println(m.maxValueOfCoins(piles, 2));
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        for(List<Integer> pile: piles)
            for(int i = 1; i < pile.size(); i++) {
                pile.set(i, (pile.get(i-1) + pile.get(i)));
                // pile.set(i, 0);
            }
        return dfs(piles, k, 0);
    }
    
    public int dfs (List<List<Integer>> piles, int k, int pileIndex) {
        if(pileIndex == piles.size() || k == 0)
            return 0;
        
        
        int max = dfs(piles, k, pileIndex + 1);
        
        for(int j = 0; j < piles.get(pileIndex).size(); j++) {
            if(j < k) {
                max = Math.max(max, piles.get(pileIndex).get(j) + dfs(piles, k - 1, pileIndex + 1));
            }
        }
        return max;
    }
}