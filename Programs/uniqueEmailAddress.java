import java.util.Set;
import java.util.HashSet;

class uniqueEmailAddress {

  public static void main(String[] args) {
    uniqueEmailAddress uea = new uniqueEmailAddress();
    System.out.println( uea.numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
  }

  public int numUniqueEmails(String[] emails) {
    Set<String> hs = new HashSet<>();
    String[] atRate, localName;

    for (String email : emails) {
      atRate = email.split("@");
      localName = atRate[0].split("\\+");
      String newEmail = localName[0];

      newEmail = newEmail.replace(".", "");

      newEmail += atRate[1];
      hs.add(newEmail);
    }
    return hs.size();
  }
}