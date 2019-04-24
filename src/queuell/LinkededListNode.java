package queuell;

public class LinkededListNode {
    Object data;
    LinkededListNode next;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LinkededListNode getNext() {
        return next;
    }

    public void setNext(LinkededListNode next) {
        this.next = next;
    }

    public LinkededListNode(Object data, LinkededListNode next) {
        this.data = data;
        this.next = next;
    }

    public LinkededListNode(Object data) {
        this.data = data;
        this.next = null;
    }
}
