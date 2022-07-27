

import java.util.*;

class uniqueEmails {
    public static void main(String orgs[]){
      String [] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
      uniqueEmails ns = new uniqueEmails();  
      System.out.println(ns.numUniqueEmails(emails));
      
    }
    public int numUniqueEmails(String[] emails) {
        Set<String> hs = new HashSet<String>(); 
        for(int i = 0; i< emails.length; ++i) {
            hs.add(addToHashSet(emails[i]));
        }
        return (hs.size());
    }
    public String addToHashSet(String email) {
        String domainName, localName;
        
        String [] names = email.split("@");
        String [] firstName = names[0].split("\\+");
        domainName = names[1];
        localName = firstName[0].replace(".","");
        return (localName +'@' + domainName);
    }
}