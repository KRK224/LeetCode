/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private List<NestedInteger> origin;
    private NestedIterator nestedIterator;
    private int size = 0;
    private int curr = -1;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.origin = nestedList;
        this.size = nestedList.size();
    }

    @Override
    public Integer next() {
        if (nestedIterator == null) {
            NestedInteger ni = origin.get(++curr);
            if (ni.isInteger()) {
                return ni.getInteger();
            } else {
                nestedIterator = new NestedIterator(ni.getList());
            }
        }

        Integer nextVal = nestedIterator.next();
        if (!nestedIterator.hasNext())
            nestedIterator = null;
        return nextVal;

    }

    @Override
    public boolean hasNext() {
        if(nestedIterator != null)
            return true;

        if(curr+1 !=size && !origin.get(curr+1).isInteger()) {
            nestedIterator = new NestedIterator(origin.get(++curr).getList());
            if(!nestedIterator.hasNext()) {
                nestedIterator = null;
                return hasNext();
            } else
                return true;
        }

        if (curr + 1 == size && nestedIterator == null)
            return false;        
        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */