

import java.util.ArrayList;
import java.util.List;

class textJustification {
    public static void main(String[] args) {
        textJustification tj = new textJustification();
        System.out.println(
                tj.fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0, n = words.length;
        while (i < n) {
            int linelen = words[i].length();
            int j = i + 1;
            while (j < n && (linelen + words[j].length() + (j - i - 1)) < maxWidth) {
                linelen += words[j].length();
                j++;
            }

            if (j >= n || (j - i == 1))
            res.add(rightJustify(words, maxWidth - linelen, i, j));
            else
            res.add(middleJustify(words, maxWidth - linelen, i, j));
            i = j;
        }
        return res;
    }

    public String middleJustify(String[] words, int diff, int i, int j) {
        int noOfSpaces = (j - i - 1);
        int defSpaces = diff / noOfSpaces;
        int extraSpace = diff % noOfSpaces;

        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; ++k) {
            int reqSpace = defSpaces + (extraSpace-- > 0 ? 1 : 0);
            sb.append(" ".repeat(reqSpace) + words[k]);
        }
        return sb.toString();
    }

    public String rightJustify(String[] words, int diff, int i, int j) {
        int noOfSpaces = (j - i - 1);
        int rightSpaces = diff - noOfSpaces;

        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; ++k) {
            sb.append(" " + words[k]);
        }
        sb.append(" ".repeat(rightSpaces));
        return sb.toString();

    }

}
