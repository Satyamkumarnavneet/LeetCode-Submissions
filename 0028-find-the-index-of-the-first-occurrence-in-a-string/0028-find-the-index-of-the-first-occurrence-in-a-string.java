class Solution {
    public int strStr(String haystack, String needle) {
    if (needle.isEmpty()) {
        return 0;
    }
    if (needle.length() > haystack.length()) {
        return -1;
    }
    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        if (haystack.charAt(i) == needle.charAt(0)) {
            boolean match = true;
            for (int j = 1; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
    }
    return -1;
}

}