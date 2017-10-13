package dsv.inte2017g11.roguelib.Items;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    private final String ITEM_NAME = "Some abstract Item";

    private Item item;


    @Test
    public void getNameTest() {
        item = new Item(ITEM_NAME) {
            @Override
            public Effect getEffect() {
                return null;
            }
        };
        assertEquals(ITEM_NAME, item.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void itemCreationTest() {
        item = new Item("") {
            @Override
            public Effect getEffect() {
                return null;
            }
        };
    }

}
