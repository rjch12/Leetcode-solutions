

class LicenseKeyFormatting {
  public static void main(String[] args) {
    LicenseKeyFormatting lkf = new LicenseKeyFormatting();
    // System.out.println(lkf.licenseKeyFormatting("5F3Z-2e-9-w", 4));
    System.out.println(lkf.licenseKeyFormatting("2-5g-3-J", 2));
  }

  public String licenseKeyFormatting(String s, int k) {
    s = s.replace("-", "");
    s = s.toUpperCase();
    String str = "";
    // 2-5G-3J
    int endIndex = s.length(), startIndex = endIndex - k;
    while (endIndex > k) {
      str = "-" + s.substring(startIndex, endIndex) + str;
      endIndex = startIndex;
      startIndex -= k;
    }
    str = s.substring(0, endIndex) + str;
    return str;
  }

}
