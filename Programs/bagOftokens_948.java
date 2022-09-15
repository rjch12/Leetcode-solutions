import java.util.*;

class bagOftokens_948 {
    public static void main(String[] args) {
        bagOftokens_948 b = new bagOftokens_948();
        System.out.println(b.bagOfTokensScore(new int[] { 58, 91 }, 50));
    }

    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 0)
            return 0;
        Arrays.sort(tokens);
        int start = 0, end = tokens.length - 1, score = 0;

        while (start <= end) {
            if (tokens[start] <= power) {
                power -= tokens[start];
                start++;
                score++;
            } else if (score > 0) {
                power += tokens[end];
                end--;
                score--;
            } else
                break;
        }
        return score;
    }
}
