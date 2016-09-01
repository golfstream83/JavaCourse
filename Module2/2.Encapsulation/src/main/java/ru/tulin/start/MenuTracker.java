package ru.tulin.start;

import ru.tulin.models.Comment;
import ru.tulin.models.Item;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */


public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[8];
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * method fills the array "actions"
     */
    public void fillActions() {
        this.actions[position++] = this.new AddItem("Add the new item");
        this.actions[position++] = this.new EditItem("Edit the item");
        this.actions[position++] = this.new DeleteItem("Delete item");
        this.actions[position++] = this.new ShowItems("Show all items");
        this.actions[position++] = this.new FilteredByName("Filtered by name");
        this.actions[position++] = this.new AddComment("Add a comment");
        this.actions[position++] = this.new ShowCommentsSingleItem("Show comments item");
        this.actions[position++] = this.new ExitFromTheProgram("Exit");
    }

    /**
     * a method of adding a new user actions
     * @param action
     */
    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    /**
     * method to call the method execute the object of the inner class by key
     * @param key
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * method to display the console a list of all available actions
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
            System.out.println(action.info());
            }
        }
    }

    /**
     * method returns a range of acceptable values ​​of menus
     * @return array result
     */
    public int[] getAcceptableRange () {
        int [] result = new int[this.actions.length];
        for (int i = 0; i != result.length; i++) {
            result[i] = actions[i].key();
        }
        return result;
    }


    private class AddItem extends BaseAction {

        public AddItem(String name) {
            super(name);
        }

        /**
         * method returns the class key
         * @return key
         */
        @Override
        public int key() {
            return 0;
        }

        /**
         * method takes the data entered by the user and starts a method of creating a new item
         * @param input
         * @param tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the tasks name: ");
            String desc = input.ask("Please, enter the tasks desc: ");
            if (name != null && !name.equals("")) {
                tracker.addItem(new Item(name, desc));
            }
        }
    }


    private class EditItem extends BaseAction {

        public EditItem(String name) {
            super(name);
        }

        /**
         * method returns the class key
         * @return
         */
        @Override
        public int key() {
            return 1;
        }

        /**
         * The method takes the data entered by the user and starts the editing method of item
         * @param input
         * @param tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            String name = input.ask("Please, enter the tasks name: ");
            String desc = input.ask("Please, enter the tasks desc: ");
            Item item = new Item(name, desc);
            item.setId(id);
            if (!name.equals("")) {
                tracker.editItem(item);
            }
        }
    }


    private class DeleteItem extends BaseAction {

        public DeleteItem(String name) {
            super(name);
        }

        /**
         * method returns the class key
         * @return key
         */
        @Override
        public int key() {
            return 2;
        }

        /**
         * The method takes the data entered by the user and removes the item with the entered id
         * @param input
         * @param tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            tracker.deleteItem(id);
        }
    }


    private class ShowItems extends BaseAction {

        public ShowItems(String name) {
            super(name);
        }

        /**
         * method returns the class key
         * @return key
         */
        @Override
        public int key() {
            return 3;
        }

        /**
         * The method outputs to the console all items
         * @param input
         * @param tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.showAllItem()) {
                System.out.println(item.toString());
            }
        }
    }


    private class FilteredByName extends BaseAction {

        public FilteredByName(String name) {
            super(name);
        }

        /**
         * method returns the class key
         * @return key
         */
        @Override
        public int key() {
            return 4;
        }

        /**
         * The method takes the user input and outputs to the console all items whose name contains the word name
         * @param input
         * @param tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            for (Item item : tracker.filteredByName(name)) {
                    System.out.println(String.format("id=%s name=%s desc=%s", item.getId(), item.getName(), item.getDescription()));
            }
        }
    }


    private class AddComment extends BaseAction {

        public AddComment(String name) {
            super(name);
        }

        /**
         * method returns the class key
         * @return key
         */
        @Override
        public int key() {
            return 5;
        }

        /**
         * method looks for id item and adds it to comment
         * @param input
         * @param tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            String comment = input.ask("Please enter a comment to the task: ");
            if (id != null && !id.equals("")) {
                Item tempItem = tracker.findById(id);
                tempItem.setComment(new Comment(comment));
            }
        }
    }

    private class ShowCommentsSingleItem extends BaseAction {

        public ShowCommentsSingleItem(String name) {
            super(name);
        }

        /**
         * method returns the class key
         * @return key
         */
        @Override
        public int key() {
            return 6;
        }

        /**
         * method of the console displays all comments item
         * @param input
         * @param tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            if (id != null && !id.equals("")) {
            Item tempItem = tracker.findById(id);
            for (Comment comment : tempItem.getComments()) {
                if (comment != null) {
                    System.out.println(comment.getComment());
                }
            }
            }
        }
    }

    private class ExitFromTheProgram extends BaseAction {
        public ExitFromTheProgram(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 7;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }
}
