package ru.tulin.start;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import ru.tulin.models.Item;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 28.08.2016
 */
public class TrackerTest {
    @Test
    public void whenAddItemShouldAdd() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        Item item = new Item("name", "description");

        //action
        assertThat(tracker.addItem(item), is(item));
    }

    @Test
    public void whenEditItemShouldChangeFieldsItem() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        Item item = new Item("name", "description");
        Item newItem = new Item("newName", "newDescription");

        //act
        tracker.addItem(item);
        newItem.setId(item.getId());
        tracker.editItem(newItem);

        //action
        assertThat(tracker.findById(item.getId()), is(newItem));
    }

    @Test
    public void whenDeleteItemShouldRemove() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "description1");
        Item item2 = new Item("name2", "description2");
        Item[] testArray = {item1};

        //act
        tracker.addItem(item1);
        tracker.addItem(item2);
        tracker.deleteItem(item2.getId());

        //action
        assertThat(tracker.showAllItem(), is(testArray));
    }

    @Test
    public void whenShowAllItemShouldShowAll() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "description1");
        Item item2 = new Item("name2", "description2");
        Item[] testArray = {item1, item2};

        //act
        tracker.addItem(item1);
        tracker.addItem(item2);

        //action
        assertThat(tracker.showAllItem(), is(testArray));
    }

    @Test
    public void whenFilteredByNameShouldFilter() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        Item item1 = new Item("number1", "description1");
        Item item2 = new Item("name", "description2");
        Item item3 = new Item("number2", "description3");
        Item[] testArray = {item1, item3};

        //act
        tracker.addItem(item1);
        tracker.addItem(item2);
        tracker.addItem(item3);

        //action
        assertThat(tracker.filteredByName("number"), is(testArray));
    }

}