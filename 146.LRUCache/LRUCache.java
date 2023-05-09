import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private int size;

    Map<Integer, DLinkListNode> cache;
    private DLinkListNode head;
    private DLinkListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>();
        head = new DLinkListNode();
        tail = new DLinkListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkListNode node = cache.get(key);
        if (node == null) {
            DLinkListNode newNode = new DLinkListNode(key, value);
            cache.put(key, newNode);
            newNode.prev = head;
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            size++;
            if (size > capacity) {
                DLinkListNode tailNode = tail.prev;
                tailNode.prev.next = tailNode.next;
                tailNode.next.prev = tailNode.prev;

                cache.remove(tailNode.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 0);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}

class DLinkListNode {
    int key;
    int value;
    DLinkListNode next;
    DLinkListNode prev;

    public DLinkListNode() {

    }

    public DLinkListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}