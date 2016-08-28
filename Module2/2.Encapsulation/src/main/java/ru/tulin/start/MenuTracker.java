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
    private UserAction[] actions = new UserAction[7];
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * method fills the array "actions"
     */
    public void fillActions() {
        this.actions[position++] = this.new AddItem(this.input, this.tracker);
        this.actions[position++] = this.new EditItem();
        this.actions[position++] = this.new DeleteItem();
        this.actions[position++] = this.new ShowItems();
        this.actions[position++] = this.new FilteredByName();
        this.actions[position++] = this.new AddComment();
        this.actions[position++] = this.new ShowCommentsSingleItem();
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


    private class AddItem implements UserAction {

        public AddItem(Input input, Tracker tracker) {
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
            tracker.addItem(new Item(name, desc));
        }

        /**
         * method creates a menu item
         * @return menu item
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");
        }
    }


    private class EditItem implements UserAction {
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
            tracker.editItem(item);
        }

        /**
         * method creates a menu item
         * @return menu item
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit the item");
        }
    }


    private class DeleteItem implements UserAction {
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

        /**
         * method creates a menu item
         * @return menu item
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }


    private class ShowItems implements UserAction {
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
                    //System.out.println(String.format("id=%s name=%s desc=%s", item.getId(), item.getName(), item.getDescription()));
                System.out.println(item.toString());
            }
        }

        /**
         * method creates a menu item
         * @return menu item
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }


    private class FilteredByName implements UserAction {
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

        /**
         * method creates a menu item
         * @return menu item
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Filtered by name");
        }
    }


    private class AddComment implements UserAction {
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
            Item tempItem = tracker.findById(id);
            tempItem.setComment(comment);
        }

        /**
         * method creates a menu item
         * @return menu item
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add a comment");
        }
    }

    private class ShowCommentsSingleItem implements UserAction {
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
            Item tempItem = tracker.findById(id);
            for (Comment comment : tempItem.getComments()) {
                if (comment != null) {
                    System.out.println(comment.getComment());
                }
            }
        }

        /**
         * method creates a menu item
         * @return menu item
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show comments item");
        }
    }
}
