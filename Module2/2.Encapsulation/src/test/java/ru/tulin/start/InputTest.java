package ru.tulin.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

import ru.tulin.models.Comment;
import ru.tulin.models.Item;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 29.08.2016
 */
public class InputTest {

    @Test
    public void whenAddItemShouldAddItemToTracker() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        String[] answers = {"0", "name", "desc"};
        StubInput stubInput = new StubInput(answers);
        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);
        String numberMenu = stubInput.ask("");

        //act
        menuTracker.fillActions();
        menuTracker.select(Integer.valueOf(numberMenu));

        //action
        assertNotNull(tracker.showAllItem()[0]);
    }

    @Test
    public void whenAddItemWithoutNameShouldNotAddItemToTracker() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        String[] answers = {"0", "", ""};
        StubInput stubInput = new StubInput(answers);
        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);
        String numberMenu = stubInput.ask("");

        //act
        menuTracker.fillActions();
        menuTracker.select(Integer.valueOf(numberMenu));

        //action
        assertThat(tracker.showAllItem().length, is(0));
    }

    @Test
    public void whenEditItemShouldEditItem() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        String[] answers = {"1", "123", "name2", "desc2"};
        StubInput stubInput = new StubInput(answers);
        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);
        String numberMenu = stubInput.ask("");
        Item item = new Item("name1", "desc1");

        //act
        menuTracker.fillActions();
        tracker.addItem(item);
        item.setId("123");
        menuTracker.select(Integer.valueOf(numberMenu));

        //action
        assertThat(tracker.showAllItem()[0].getName(), containsString("name2"));
    }

    @Test
    public void whenEditItemWithoutNameShouldNotEditItem() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        String[] answers = {"1", "123", "", "desc2"};
        StubInput stubInput = new StubInput(answers);
        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);
        String numberMenu = stubInput.ask("");
        Item item = new Item("name1", "desc1");

        //act
        menuTracker.fillActions();
        tracker.addItem(item);
        item.setId("123");
        menuTracker.select(Integer.valueOf(numberMenu));

        //action
        assertTrue(!tracker.showAllItem()[0].getName().equals(""));
    }

    @Test
    public void whenDeleteItemShouldDeleteItemFromTracker() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        String[] answers = {"2", "123"};
        StubInput stubInput = new StubInput(answers);
        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);
        String numberMenu = stubInput.ask("");
        Item item = new Item("name", "desc");

        //act
        menuTracker.fillActions();
        tracker.addItem(item);
        item.setId("123");
        menuTracker.select(Integer.valueOf(numberMenu));

        //action
        assertThat(tracker.showAllItem().length, is(0));
    }

    @Test
    public void whenShowAllItemsShouldAllItemsTracker() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        String[] answers = {"3"};
        StubInput stubInput = new StubInput(answers);
        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);
        String numberMenu = stubInput.ask("");
        Item item = new Item("name", "desc");
        Item item2 = new Item("name2", "desc2");

        //act
        menuTracker.fillActions();
        tracker.addItem(item);
        tracker.addItem(item2);
        menuTracker.select(Integer.valueOf(numberMenu));

        //action
        assertThat(tracker.showAllItem().length, is(2));
    }

    @Test
    public void whenShowItemsByNameShouldAllItemsWhoseNameContainsTheKeyword() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        String[] answers = {"4", "name"};
        StubInput stubInput = new StubInput(answers);
        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);
        String numberMenu = stubInput.ask("");
        Item item = new Item("name", "desc");
        Item item2 = new Item("item", "desc");
        Item item3 = new Item("name2", "desc2");

        //act
        menuTracker.fillActions();
        tracker.addItem(item);
        tracker.addItem(item2);
        tracker.addItem(item3);
        menuTracker.select(Integer.valueOf(numberMenu));

        //action
        assertThat(tracker.filteredByName("name").length, is(2));
    }

    @Test
    public void whenAddCommentToItemShouldAddComment() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        String[] answers = {"5", "123", "comment"};
        StubInput stubInput = new StubInput(answers);
        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);
        String numberMenu = stubInput.ask("");
        Item item = new Item("name", "desc");

        //act
        menuTracker.fillActions();
        tracker.addItem(item);
        item.setId("123");
        menuTracker.select(Integer.valueOf(numberMenu));

        //action
        assertFalse(tracker.showAllItem()[0].getComments()[0] == null);
    }

    @Test
    public void whenAddSeveralCommentsToItemShouldAddComments() throws Exception {
        //assign
        Tracker tracker = new Tracker();
        String[] answers = {"6", "123"};
        StubInput stubInput = new StubInput(answers);
        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);
        String numberMenu = stubInput.ask("");
        Item item = new Item("name", "desc");

        //act
        menuTracker.fillActions();
        tracker.addItem(item);
        item.setId("123");
        item.setComment(new Comment("comment1"));
        item.setComment(new Comment("comment2"));
        menuTracker.select(Integer.valueOf(numberMenu));

        //action
        assertTrue(tracker.showAllItem()[0].getComments()[0] != null);
        assertTrue(tracker.showAllItem()[0].getComments()[1] != null);
    }
}
