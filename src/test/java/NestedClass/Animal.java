package NestedClass;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    public int x = 20;

    class Bird {
        public int x = 10;

        class Eagle {
            public int x = 5;
            List<Integer> showAllX() {
                List<Integer> showAllX = new ArrayList<Integer>();
                showAllX.add(x);
                showAllX.add(Bird.this.x);
                showAllX.add(Animal.this.x);
                return showAllX;
            }
        }
    }
}
