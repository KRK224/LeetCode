class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<Person> pList = new ArrayList<>();
        int l = names.length;
        for(int i =0; i< l; i++) {
            pList.add(new Person(names[i], heights[i]));
        }
        Collections.sort(pList, (p1, p2) -> p2.height - p1.height);        
        List<String> answer = new ArrayList<>();
        for(int i =0; i< l; i++) {
            answer.add(pList.get(i).name);
        }

        return answer.toArray(new String[0]);
    }

    public class Person {
        public String name;
        public int height;

        public Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}