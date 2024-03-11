package com.data.struct.basic;

public class LinkListApp {

    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(1, 1.0);
        theList.insertFirst(2,2.0);
        theList.insertFirst(3,3.0);
        theList.insertFirst(4,4.0);
        // display list
        theList.displayList();

        Link f = theList.find(3);
        if (f != null) {
            System.out.println("Found link with key " + f.iData);
        } else {
            System.out.println("Can't find link");
        }

        Link d = theList.delete(2);
        if (d != null) {
            System.out.println("Delete link with key " + d.iData);
        } else {
            System.out.println("Can't delete link");
        }
        theList.displayList();
    }


    public static void main2(String[] args) {
        // make new list
        LinkList  theList = new LinkList();

        // inser four items
        theList.insertFirst(1, 1);
        theList.insertFirst(2, 2);
        theList.insertFirst(3,3);
        theList.insertFirst(4,4);
        // display list
        theList.displayList();
        while (! theList.isEmpty()) {
            Link  aLink = theList.deleteFirst();
            System.out.println("Delete ");
            aLink.displayLink();
        }
    }
}