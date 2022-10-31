public class MyLinkedList {

    LinkNode head;
    LinkNode tail;
    int size;

    public MyLinkedList() {
        head = new LinkNode(-1);
        tail = head;
        size = 0;
    }

    public int get(int index) {
        LinkNode tNode = getNode(index);
        if (tNode == null) {
            return -1;
        }
        return tNode.val;
    }

    public void addAtHead(int val) {
        insertNode(head, val);
        if (size == 1) {
            tail = tail.next;
        }
    }

    public void addAtTail(int val) {
        insertNode(tail, val);
        tail = tail.next;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index > size) {
            return;
        }
        LinkNode pre = getNode(index - 1);
        insertNode(pre, val);
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        LinkNode tNode = head;
        for (int i = 0; i < index; i++) {
            tNode = tNode.next;
        }
        tNode.next = tNode.next.next;
        if (tNode.next == null) {
            tail = tNode;
        }
        size--;
    }

    private LinkNode getNode(int index) {
        if (index >= size) {
            return null;
        }
        LinkNode ret = head;
        for (int i = 0; i <= index; i++) {
            ret = ret.next;
        }
        return ret;
    }

    private void insertNode(LinkNode pre, int val) {
        LinkNode tNode = pre.next;
        LinkNode temp = new LinkNode(val);
        pre.next = temp;
        temp.next = tNode;
        size++;
    }

    public static void main(String[] args) {
        Main linkedList = new Main();
        linkedList.addAtHead(1);
        linkedList.addAtHead(2);
        linkedList.addAtTail(3);
        linkedList.addAtTail(4);
        linkedList.addAtIndex(1, 5);//链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));//返回2
        linkedList.deleteAtIndex(4);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));//返回3
    }
}

class LinkNode {
    int val;
    LinkNode next;

    LinkNode(int val) {
        this.val = val;
        this.next = null;
    }

    LinkNode(int val, LinkNode next) {
        this.val = val;
        this.next = next;
    }
}