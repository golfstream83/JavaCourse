package ru.tulin.models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 29.08.2016
 */
public class ItemTest {
    @Test
    public void whenGetCommentsShouldGetAllCommentsOfItem() throws Exception {
        //assign
        Comment comment = new Comment("comment");
        Item item = new Item("name", "description");

        //act
        item.setComment(comment);
        Comment[] testArray = {comment, null, null, null, null};

        //action
        assertThat(item.getComments(), is(testArray));
    }

    @Test
    public void whenSetCommentShouldAddComment() throws Exception {
        //assign
        Comment comment = new Comment("comment");
        Item item = new Item("name", "description");

        //act
        item.setComment(comment);
        Comment[] testArray = {comment, null, null, null, null};

        //action
        assertThat(item.getComments(), is(testArray));
    }

}