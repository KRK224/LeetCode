class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> ls = new ArrayList<>();
        List<String> ds = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ", 2)[1].charAt(0))) {
                ds.add(log);
            } else {
                ls.add(log);
            }
        }
        Collections.sort(ls, (s1, s2) -> {
            String[] sp1 = s1.split(" ", 2);
            String[] sp2 = s2.split(" ", 2);

            int result = sp1[1].compareTo(sp2[1]);
            if (result == 0) {
                return sp1[0].compareTo(sp2[0]);
            }
            return result;
        });

        ls.addAll(ds);
        return ls.toArray(new String[0]);

    }
}