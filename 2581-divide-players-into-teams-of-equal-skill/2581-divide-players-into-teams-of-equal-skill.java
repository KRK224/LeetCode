class Solution {
    public long dividePlayers(int[] skill) {
        long ans = 0L;
        int n = skill.length;
        long sum = 0;
        int eSkill = 0;
        int[] freq = new int[1001];
        for(int i: skill) {
            sum +=i;
            freq[i]++;
        }

        if(sum % (n/2) != 0) {
            return -1L;
        }
        eSkill = (int) sum / (n/2);

        for(int s: skill) {
            int ps = eSkill -s;
            if(freq[ps] ==0)
                return -1L;
            ans += ps *s;
            freq[ps]--;
        }

        return ans /2;
    }
}