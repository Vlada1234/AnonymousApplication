public class Test {
    public int reverseList(int head ) {
        int prev = Integer.parseInt(null);

        while(head != null) {
             next = head.next;
            head.next = prev;
        }
    }
}
