/*
* Design an Iterator class, which has:
    A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
    A function next() that returns the next combination of length combinationLength in lexicographical order.
    A function hasNext() that returns True if and only if there exists a next combination.
* Example: CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
    iterator.next(); // returns "ab"
    iterator.hasNext(); // returns true
    iterator.next(); // returns "ac"
    iterator.hasNext(); // returns true
    iterator.next(); // returns "bc"
    iterator.hasNext(); // returns false
* Constraints:
    1 <= combinationLength <= characters.length <= 15
    There will be at most 10^4 function calls per test.
    It's guaranteed that all calls of the function next are valid.
* */

class CombinationIterator {
    Queue<String> stringQueue = new LinkedList();
    String originalString = "";
    public CombinationIterator(String characters, int combinationLength) {
        originalString = characters;
        find("", 0, combinationLength);
    }

    void find(String str, int index, int len) {
        if(len ==0) {
            stringQueue.add(str);
            return;
        }
        for(int i= index; i<originalString.length(); i++) {
            char ch = originalString.charAt(i);
            find(str+ch , i+1, len-1);
        }

    }

    public String next() {
        if(!stringQueue.isEmpty()) {
            return stringQueue.poll();
        }
        return "";
    }

    public boolean hasNext() {
        return !stringQueue.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */