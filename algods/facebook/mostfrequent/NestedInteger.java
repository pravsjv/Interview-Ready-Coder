package algods.facebook.mostfrequent;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
      private
 
boolean isInteger;
    private
 
int value;
    private List<NestedInteger> nestedList;

    public NestedInteger() {
        this.isInteger = false;
        this.nestedList = new ArrayList<>();
    }

    public NestedInteger(int value) {
        this.isInteger = true;
        this.value = value;
        this.nestedList = null;
    }

    public boolean isInteger() {
        return this.isInteger;
    }

    public Integer getInteger() {
        if (!this.isInteger) {
            throw new IllegalStateException("This NestedInteger holds a nested list, not an integer.");
        }
        return this.value;
    }

    public void setInteger(int value) {
        this.isInteger = true;
        this.value = value;
        this.nestedList = null;
    }

    public void add(NestedInteger ni) {
        if (!this.isInteger) {
            this.nestedList.add(ni);
        } else {
            throw new IllegalStateException("Cannot add to a NestedInteger holding an integer.");
        }
    }

    public List<NestedInteger> getList() {
        if (this.isInteger) {
            throw new IllegalStateException("This NestedInteger holds an integer, not a nested list.");
        }
        return this.nestedList;
    }
  }
