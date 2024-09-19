class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        List<String> l = new ArrayList();

        for (int i : nums) {
            l.add(Integer.toString(i));
        }

        l.sort((s1, s2) -> {
            return (s2 + s1).compareTo(s1 + s2);
        });

        if (l.get(0).equals("0")) {
            return "0";
        }

        for (String e : l) {
            sb.append(e);
        }
        return sb.toString();

    }
    // Map<String, List<String>> b = new HashMap<>();

    // // bucket initialized
    // for(int i : nums) {
    // String s = i + "";
    // List<String> l = b.getOrDefault(s.substring(0,1), new ArrayList<>());
    // l.add(s);
    // b.put(s.substring(0,1), l);
    // }

    // for(int i = 9; i>= 0; i--) {
    // String key = i +"";
    // List<String> l = b.get(key);
    // if(l != null) {
    // System.out.println("key: " + key);
    // for(String e: l) {
    // System.out.println(e);
    // }
    // l.sort((s1, s2) -> {
    // String s1F = s1 + s2;
    // String s2F = s2 + s1;
    // return s2F.compareTo(s1F);
    // });

    // for(String s: l) {
    // sb.append(s);
    // }
    // }
    // }

    // String ans = sb.toString();
    // if(ans.charAt(0)== '0') {
    // return "0";
    // }
    // return ans;

    // }

}