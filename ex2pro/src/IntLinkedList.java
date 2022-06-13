public class IntLinkedList {

    private class Node {
        private int val;
        private Node next;

        private Node(int val) {
            this.val = val;
            next = null;
        }

        private Node(int val, Node nextp) {
            this.val = val;
            next = nextp;
        }

        private int getval() {
            return val;
        }

        private boolean hasnext() {
            return next != null;
        }

        public Node getnext() {
            return next;
        }


    }

    private Node head;

    public Node find(int val) {
        Node temp = head;
        if (temp.getval() == val)
            return temp;
        while (temp.hasnext()) {
            if (temp.getval() == val)
                return temp;
            else {
                temp = temp.getnext();
            }

        }

        return null;
    }

    public boolean remove(Node remove)
    {
        if (remove == head)
        {
            head = head.getnext();
            return true;
        }
        if (find(remove.getval()) != null) ;
        {
            Node temp = head;
            while (temp.hasnext()&&temp.getnext().hasnext())
            {

                if (temp.getnext() == remove) {
                    temp.next = temp.getnext().getnext();
                    return true;
                }
                temp = temp.getnext();

            }

        }
        return false;
    }

    public boolean add(int val)
    {
        Node add=new Node(val);
        if (find(add.getval()) == null) {
            add.next = head.getnext();
            head.next = add;
            return true;
        }
        return false;
    }

    public IntLinkedList(int val) {
        head = new Node(val);
    }

    public IntLinkedList(int val, Node nextp) {
        head = new Node(val, nextp);
    }

    public void print() {
        Node temp = head;
        System.out.println("");
        while (temp!=null) {
            if(temp.getnext()!=null)
            {
                    System.out.print(temp.getval()+"-->");
            }
            else
                System.out.print(temp.getval());

            temp=temp.getnext();

        }
    }

    public static void main(String [] args)
    {
        int i =0;
        IntLinkedList myIntLinkedList=new IntLinkedList(1);
        while (i<1000)
        {
            myIntLinkedList.add(i);
            i++;
        }

        myIntLinkedList.remove( myIntLinkedList.find(990));
        myIntLinkedList.print();

    }
}
