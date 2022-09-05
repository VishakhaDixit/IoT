public class empLinkedList {
    private int size;
    private empNode start;

    static class empNode {
        private Double salary;
        private empNode next;
        
        //Default initialization
        public empNode() 
        {
            salary = 0.00;
            next = null;
        }
        public empNode(Double s, empNode n) 
        {
            salary = s;
            next = n;
        }
    
        public void setData(Double s) 
        {
            salary = s;
        }
        public void setNext(empNode n) 
        {
            next = n;
        }
        public Double getData() 
        {
            return(salary);
        }
        public empNode getNext() 
        {
            return(next);
        }
    }

    public empLinkedList() 
    {
        size = 0;
        start = null;
    }

    private void setHead(Double val)
    {
        empNode node = new empNode();
        node.setData(val);
        node.setNext(start);
        start = node;
        size++;
    }

    private void setTail(Double val)
    {
        empNode node = new empNode();
        node.setData(val);

        empNode cur = start;

        if(cur == null)
            start = node;
        else
        {
            while(cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(node);
        }
        size++;
    }

    private void insertAtPos(int pos, Double val)
    {
        if(pos == 1)
            setHead(val);
        else if(pos == size+1)
            setTail(val);
        else if(pos > 1 && pos <= size)
        {
            empNode n = new empNode(val, null);
            
            empNode cur = start;
            for(int i = 1; i < pos-1; i++)
                cur = cur.getNext();

            n.setNext(cur.getNext());
            cur.setNext(n);
            size++;
        }
        else 
        {
            System.out.println("Error: Insertion not possible at position " + pos);
        }
    }

    public void insert(Double val)
    {
        empNode cur = start;
        int pos = 1;

        while(cur != null)
        {
            if(val > cur.getData())
            {
                cur = cur.getNext();
                pos++;
            }
            else
                break;
        }
        insertAtPos(pos, val);
    }

    private void deleteHead()
    {
        if(isEmpty())
            System.out.println("Error: List is already Empty!!");
        else
        {
            start = start.getNext();
            size--;
        }
    }

    private void deleteTail()
    {
        if(start == null)
            System.out.println("Error: List is already Empty!!");
        else if(size == 1)
        {
            start = null;
            size--;
        }
        else 
        {
            empNode n;
            n = start;
            for(int i = 1; i < size-1; i++)
                n = n.getNext();
            n.setNext(null);
            size--;
        }
    }

    private void deleteAtPos(int pos)
    {
        if(start == null)
            System.out.println("Error: List is already Empty!!");
        else if(pos < 1 || pos > size)
            System.out.println("Error: Invalid Position value!!");
        else if(pos == 1)
            deleteHead();
        else if(pos == size)
            deleteTail();
        else 
        {
            empNode t, t1;
            t = start;

            for(int i = 1; i < pos-1; i++)
                t = t.getNext();
            t1 = t.getNext();
            t.setNext(t1.getNext());
            size--;
        }
    }

    public void delete(Double val)
    {
        empNode cur = start;
        int pos = 1;

        while(cur != null)
        {
            if(cur.getData() < val)
                pos++; 
            else if(cur.getData() == val)
                deleteAtPos(pos); 
            else if(cur.getData() > val)
                break;
        }
    }

    public boolean isEmpty() 
    {
        if(start == null)
            return(true);
        else
            return(false);
    }

    public int getListSize() 
    {
        return(size);
    }

    public void viewList()
    {
        empNode curNode;

        if(isEmpty())
            System.out.println("Linked List is Empty!!");
        else
        {
            curNode = start;
            for(int i = 1; i <= size; i++)
            {
                System.out.println("Employee" + i + ":" + curNode.getData());
                curNode = curNode.getNext();
            }
        }
    }
}
