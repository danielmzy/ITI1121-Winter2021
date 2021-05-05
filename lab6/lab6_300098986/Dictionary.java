public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        elems = new Pair[INITIAL_CAPACITY];
        count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        if (count >= this.getCapacity()) {
            this.increaseCapacity();
        }
        elems[count] = new Pair(key,value);
        count++;
    }

    private void increaseCapacity() {
        /* Your code here.  Use this in put() where necessary. */
        Pair[] temp = new Pair[this.getCapacity()+INCREMENT];
        for (int i = 0; i<elems.length; i++) {
            temp[i] = elems[i];
        }
        elems = temp;
    }

    @Override
    public boolean contains(String key) {
        /* Your code here. */
        for (int i = 0; i<count; i++) {
            if (elems[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public Integer get(String key) {
        /* Your code here. */
        for (int i = count-1; i>=0; i--){
            if (elems[i].getKey().equals(key)) {
                return elems[i].getValue();
            }
        }
        return -1;
    }

    @Override
    public void replace(String key, Integer value) {
        /* Your code here. */
        for (int i = count-1; i>=0; i--){
            if (elems[i].getKey().equals(key)){
                elems[i].setValue(value);
            }
        }
    }

    @Override
    public Integer remove(String key) {
        /* Your code here. */
        int removed = 0;
        boolean found = false;
        Pair[] temp = new Pair[count];
        int i = count-1;
        Integer stored = -1;

        while(i>=0 && !found) {
            if (elems[i].getKey().equals(key)){
                stored = elems[i].getValue();
                elems[i] = null;
                found = true;
            }
            else {
                temp[count-i-1] = elems[i];
                removed++;
                i--;
            }
        }

        if (found) {
            for (i = 0; i<removed; i++){
                elems[count-removed-1+i] = temp[i];
            }
            count--;
        }
        return stored;
    }

    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

}