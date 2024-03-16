package com.data.struct.basic.linkList;

/**
 * 链表的节点
 */
public class Link {
    public int iData;    // data item
    public double dData; // data item
    public Link next;    // next link in list
    public Link(int id, double dd)  // constructor
    {
        iData = id;  // initialize data
        dData = dd;  // ('next' is automatically set to null)
    }
    // display ourself
    public void displayLink() {
        System.out.println("{" + iData + ", " + dData + "} ");
    }
}