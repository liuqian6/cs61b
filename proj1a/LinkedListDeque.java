public class LinkedListDeque<T> {

    private class LinkedNode {
        LinkedNode pre;
        T item;
        LinkedNode next;

        public LinkedNode(LinkedNode p, T i, LinkedNode n) {
            pre = p;
            item = i;
            next = n;
        }
    }

    private LinkedNode sentinel;
    private int size;

    public LinkedListDeque(T item) {
        size += 1;
        sentinel = new LinkedNode(null, item, null);
        LinkedNode l = new LinkedNode(sentinel, item, sentinel);
        sentinel.pre = l;
        sentinel.next = l;
    }

    public LinkedListDeque() {
        sentinel = new LinkedNode(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        size += 1;
        LinkedNode l = new LinkedNode(sentinel, item, sentinel.pre);
        sentinel.pre.pre = l;
        sentinel.pre = l;
        if (size == 1) {
            sentinel.next = l;
        }

    }

    public void addLast(T item) {
        size += 1;
        LinkedNode l = new LinkedNode(sentinel.next, item, sentinel);
        sentinel.next.next = l;
        sentinel.next = l;
        if (size == 1) {
            sentinel.pre = l;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
