public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            enlargeSize();
        }
        size += 1;
        items[nextFirst] = item;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst += items.length;
        }
    }

    public void addLast(T item) {
        if (size == items.length) {
            enlargeSize();
        }
        size += 1;
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
    }

    public void enlargeSize() {
        T[] newItems = (T[]) new Object[items.length * 2];
        int firstPosition = (nextFirst + 1) % items.length;
        System.arraycopy(items, firstPosition, newItems, 0, items.length - firstPosition);
        System.arraycopy(items, 0, newItems, items.length - firstPosition, firstPosition);
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = items.length / 2;
    }

    public void shrinkSize() {
        if (items.length > 8 && items.length / size >= 4) {
            T[] newItems = (T[]) new Object[items.length / 2];
            int firstPosition = (nextFirst + 1) % items.length;
            int lastPosition = nextLast - 1 < 0 ? items.length + nextLast - 1 : nextLast - 1;
            if (firstPosition > lastPosition) {
                System.arraycopy(items, firstPosition, newItems, 0, items.length - firstPosition);
                System.arraycopy(items, 0, newItems, items.length - firstPosition, firstPosition);
            }
            if (firstPosition < lastPosition) {
                System.arraycopy(items, firstPosition, newItems, 0, size);
            }
            items = newItems;
            nextFirst = items.length - 1;
            nextLast = size;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            int position = (nextFirst + 1 + i) % items.length;
            System.out.print(items[position] + " ");
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        int position = (nextFirst + 1) % items.length;
        T item = items[position];
        items[position] = null;
        nextFirst = position;
        shrinkSize();
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        int position = nextLast - 1;
        if (position < 0) {
            position += items.length;
        }
        T item = items[position];
        items[position] = null;
        nextLast = position;
        shrinkSize();
        return item;
    }

    public T get(int index) {
        int position = (nextFirst + 1 + index) % items.length;
        return items[position];
    }

    public static void main(String args[]) {
        ArrayDeque<String> arrays = new ArrayDeque<>();
        arrays.addFirst("a");
        arrays.addFirst("b");
        arrays.addFirst("c");
        arrays.addLast("d");
        arrays.addLast("e");
        arrays.addLast("f");
        arrays.addLast("g");
        arrays.addLast("h");
        arrays.addLast("i");
        arrays.addLast("j");
        arrays.addLast("k");
        arrays.addFirst("l");
        arrays.addFirst("m");
        arrays.addFirst("n");
        arrays.removeLast();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.removeFirst();
        arrays.printDeque();
    }
}
