import java.util.NoSuchElementException;

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
        this.count = 0;
        elems = new Pair[INITIAL_CAPACITY];
    }

    public void put(String key, Integer value) {
        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
        } else {
            if (contains(key)) {
                elems[count++] = new Pair(key, value);
                count++;
            } else {
                increaseCapacity();
                elems[count++] = new Pair(key, value);
            }
        }
    }

    private void increaseCapacity() {

        if (count >= getCapacity()) {
            Pair[] tempoElem = elems;
            elems = new Pair[tempoElem.length + INCREMENT];
            for (int i = 0; i < tempoElem.length; i++) {
                elems[i] = tempoElem[i];
            }
        }
    }

    public boolean contains(String key) {
        if (key == null) {
            throw new NullPointerException("Why is the value null?");
        } else {
            try {
                for (int i = 0; i < elems.length; i++) {
                    if (elems[i].getKey().equals(key)) {
                        return true;
                    }
                }
            } catch (Exception e) {
                return false;
            }
            return false;
        }
    }

    public Integer get(String key) {
        boolean found = false;
        if (key == null) {
            throw new NullPointerException("Why is the value null?");
        } else {

            for (int i = elems.length - 1; i >= 0; i--) {
                if (elems[i] != null && elems[i].getKey().equals(key)) {
                    found = true;
                    return elems[i].getValue();
                }
            }
            if (!found) {
                throw new NoSuchElementException("Sorry, Does not exist");
            }
            return null;
        }
    }

    public void replace(String key, Integer value) {
        boolean indoor = false;
        if (key == null || value == null) {
            throw new NullPointerException("Does not exist");
        } else {
            for (Pair element : elems) {
                if (element != null && element.getKey().equals(key)) {
                    indoor = true;
                    element.setValue(value);
                }
            }
            if (!indoor) {
                throw new NoSuchElementException("Sorry, it does not exist");
            }
        }
    }

    public Integer remove(String key) {
        boolean found = false;
        if (key == null) {
            throw new NullPointerException("Does not exist");
        }
        int container = 0;
        for (int i = elems.length - 1; i > -1; i--) {
            if (elems[i] != null) {
                if (elems[i].getKey().equals(key)) {
                    found = true;
                    container = elems[i].getValue();
                    elems[i] = null;
                    count--;
                    return container;
                }
            }
        }
        if (!found) {
            throw new NoSuchElementException("Does not exist");
        }
        return null;
        // if(key==null){
        // throw new NoSuchElementException("Does not exist");
        // }
        // replace(null, null);
        // count--;
        // return get(key);
    }

    @Override
    public String toString() {
        String res;
        res = "Dictionary: {elems = [";
        for (int i = count - 1; i >= 0; i--) {
            res += elems[i];
            if (i > 0) {
                res += ", ";
            }
        }
        return res + "]}";
    }

}