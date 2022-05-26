public class LinkedList {

    int value;
    LinkedList next;

    public LinkedList(int value) {
        this.value = value;
    }

    public void add(int value) {

    }
    
    public void add(int value, int pos) {

    }
    
    public void del(int value) {

    }

    public void del(int value, int pos) {

    }

    public int find(int value) {
        return 0;
    }

    public int size() {
        return 0;
    }

    public static void printlist(LinkedList llist) {
        if (llist == null) {
            //print nothing
            System.out.println();
        } else {
            if (llist.next == null) {
                System.out.println(llist.value);
            } else {
                System.out.print(llist.value + " ");
                printlist(llist.next);
            }
        }
    }
    
    @Override
    public String toString() {
        if (this.next == null) {
            return this.value + "";
        } else {
            return this.value + " " + this.next.toString();
        }
        
    }
}