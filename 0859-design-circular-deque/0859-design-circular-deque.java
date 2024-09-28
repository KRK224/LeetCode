class MyCircularDeque {
    int volume;
    int size;
    DequeElement first = null;
    DequeElement last = null;

    public class DequeElement {
        public int data;
        public DequeElement prev;
        public DequeElement next;

        DequeElement(int data, DequeElement prev, DequeElement next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyCircularDeque(int k) {
        this.size = k;
        this.volume = 0;
    }
    
    public boolean insertFront(int value) {
        // 이미 꽉 찬 경우
        if(volume == size)
            return false;

        volume++;
        // 데이터가 아무것도 없는 경우
        if(first == null && last ==null) {
            first = new DequeElement(value, null, null);
            last = first;
        } else {
           DequeElement tmp = new DequeElement(value, null, first);
           first.prev = tmp;
           first = tmp;
        }

        return true;
    }
    
    public boolean insertLast(int value) {
        if(volume == size)
            return false;
        
        volume++;

        if(last == null && first == null) {
            last = new DequeElement(value, null, null);
            first = last;
        } else {
            DequeElement tmp = new DequeElement(value, last, null);
            last.next = tmp;
            last = tmp;
        }
        return true;
    }
    
    public boolean deleteFront() {
        if(volume == 0)
            return false;
        
        volume--;
        // 1 element
        if(first == last) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        return true;
    }
    
    public boolean deleteLast() {
        if(volume == 0) 
            return false;
        
        volume--;
        if(first == last) {
            first = null;
            last = null;
        } else {
            last = last.prev;
        }
        return true;
    }
    
    public int getFront() {
        if(isEmpty())
            return -1;
        else {
            return first.data;
        }
    }
    
    public int getRear() {
        if(isEmpty())
            return -1;
        else {
            return last.data;
        }
        
    }
    
    public boolean isEmpty() {
        if(volume == 0)
            return true;
        else
            return false;
    }
    
    public boolean isFull() {
        if(volume == size)
            return true;
        else
            return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */