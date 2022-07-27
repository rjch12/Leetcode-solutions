

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class guessTheWord_843 {
  public static void main(String[] args) {
    guessTheWord_843 gtw = new guessTheWord_843();

    // gtw.findSecretWord(new String[] {"acckzz","ccbazz","eiowzz","abcczz"});
    gtw.findSecretWord(new String[] { "gaxckt", "trlccr", "jxwhkz", "ycbfps", "peayuf", "yiejjw", "ldzccp", "nqsjoa",
        "qrjasy", "pcldos", "acrtag", "buyeia", "ubmtpj", "drtclz", "zqderp", "snywek", "caoztp", "ibpghw", "evtkhl",
        "bhpfla", "ymqhxk", "qkvipb", "tvmued", "rvbass", "axeasm", "qolsjg", "roswcb", "vdjgxx", "bugbyv", "zipjpc",
        "tamszl", "osdifo", "dvxlxm", "iwmyfb", "wmnwhe", "hslnop", "nkrfwn", "puvgve", "rqsqpq", "jwoswl", "tittgf",
        "evqsqe", "aishiv", "pmwovj", "sorbte", "hbaczn", "coifed", "hrctvp", "vkytbw", "dizcxz", "arabol", "uywurk",
        "ppywdo", "resfls", "tmoliy", "etriev", "oanvlx", "wcsnzy", "loufkw", "onnwcy", "novblw", "mtxgwe", "rgrdbt",
        "ckolob", "kxnflb", "phonmg", "egcdab", "cykndr", "lkzobv", "ifwmwp", "jqmbib", "mypnvf", "lnrgnj", "clijwa",
        "kiioqr", "syzebr", "rqsmhg", "sczjmz", "hsdjfp", "mjcgvm", "ajotcx", "olgnfv", "mjyjxj", "wzgbmg", "lpcnbj",
        "yjjlwn", "blrogv", "bdplzs", "oxblph", "twejel", "rupapy", "euwrrz", "apiqzu", "ydcroj", "ldvzgq", "zailgu",
        "xgqpsr", "wxdyho", "alrplq", "brklfk" });
    // gtw.findSecretWord(new String[] { "eykdft", "gjeixr", "eksbjm", "mxqhpk",
    // "tjplhf", "ejgdra", "npkysm", "jsrsid",
    // "cymplm", "vegdgt", "jnhdvb", "jdhlzb", "sgrghh", "jvydne", "laxvnm",
    // "xbcliw", "emnfcw", "pyzdnq", "vzqbuk",
    // "gznrnn", "robxqx", "oadnrt", "kzwyuf", "ahlfab", "zawvdf", "edhumz",
    // "gkgiml", "wqqtla", "csamxn", "bisxbn",
    // "zwxbql", "euzpol", "mckltw", "bbnpsg", "ynqeqw", "uwvqcg", "hegrnc",
    // "rrqhbp", "tpfmlh", "wfgfbe", "tpvftd",
    // "phspjr", "apbhwb", "yjihwh", "zgspss", "pesnwj", "dchpxq", "axduwd",
    // "ropxqf", "gahkbq", "yxudiu", "dsvwry",
    // "ecfkxn", "hmgflc", "fdaowp", "hrixpl", "czkgyp", "mmqfao", "qkkqnz",
    // "lkzaxu", "cngmyn", "nmckcy", "alpcyy",
    // "plcmts", "proitu", "tpzbok", "vixjqn", "suwhab", "dqqkxg", "ynatlx",
    // "wmbjxe", "hynjdf", "xtcavp", "avjjjj",
    // "fmclkd", "ngxcal", "neyvpq", "cwcdhi", "cfanhh", "ruvdsa", "pvzfyx",
    // "hmdmtx", "pepbsy", "tgpnql", "zhuqlj",
    // "tdrsfx", "xxxyle", "zqwazc", "hsukcb", "aqtdvn", "zxbxps", "wziidg",
    // "tsuxvr", "florrj", "rpuorf", "jzckev",
    // "qecnsc", "rrjdyh", "zjtdaw", "dknezk" });

  }

  public int guess(String s1) {
    // String secret = "cymplm";
    String secret = "hbaczn";
    int guess = 0;
    for (int i = 0; i < s1.length(); ++i) {
      if (s1.charAt(i) == secret.charAt(i)) {
        guess++;
      }
    }
    return guess;
  }

  public void findSecretWord(String[] wordlist) {
    Random r = new Random();
    int guesses = 10;

    while (guesses > 0) {
      int ind = r.nextInt(wordlist.length);
      String s = wordlist[ind];
      int guess = guess(s);
      if (guess == 6)
        return;
      guesses--;
      List<String> al = new ArrayList<>();

      for (String words : wordlist) {
        if (words == s)
          continue;
        if (matchScore(s, words) == guess) {
          al.add(words);
        }
      }
      String arr[] = new String[al.size()];
      wordlist = al.toArray(arr);
    }
  }

  private int matchScore(String s1, String s2) {
    int guess = 0;
    for (int i = 0; i < s1.length(); ++i) {
      if (s1.charAt(i) == s2.charAt(i)) {
        guess++;
      }
    }
    return guess;
  }
}
