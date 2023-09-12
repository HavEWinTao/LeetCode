import java.util.HashMap;

class LRUCache {

    private int capacity;

    private HashMap<Integer, DeLinkList.Node> map;

    private DeLinkList deLinkList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        deLinkList = new DeLinkList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DeLinkList.Node node = map.get(key);
        deLinkList.moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        DeLinkList.Node node = new DeLinkList.Node(key, value);
        if (map.size() < capacity) {
            deLinkList.addToHead(node);
        } else {
            int tail = deLinkList.removeTail();
            map.remove(tail);
            deLinkList.addToHead(node);
        }
        map.put(key, node);
    }
}


class DeLinkList {

    static class Node {
        Node next;
        Node prev;
        int key;
        int val;

        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node tail;

    DeLinkList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    public int removeTail() {
        Node node = tail.prev;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return node.key;
    }
}


public class Solution {
    public static void main(String[] args) {
        {
            LRUCache lruCache = new LRUCache(2);
            int ret;
            lruCache.put(1, 0);
            lruCache.put(2, 2);
            ret = lruCache.get(1);
            lruCache.put(3, 3);
            ret = lruCache.get(2);
            lruCache.put(4, 4);
            ret = lruCache.get(1);
            ret = lruCache.get(3);
            ret = lruCache.get(4);
        }
        {
            LRUCache lruCache = new LRUCache(2);
            int ret;
            ret = lruCache.get(2);
            lruCache.put(2, 6);
            ret = lruCache.get(1);
            lruCache.put(1, 5);
            lruCache.put(1, 2);
            ret = lruCache.get(1);
            ret = lruCache.get(2);
        }
    }
}
