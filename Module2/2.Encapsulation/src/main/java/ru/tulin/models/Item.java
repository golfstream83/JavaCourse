package ru.tulin.models;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */
public class Item {
    public String name;
    public String description;
    private long create;
    private String id;
    private String comments[] = new String[10];

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
    * Getter for the field "name"
    * @return name
     */
    public String getName() {
        return name;
    }

    /**
    * Setter for the field "name"
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the field "description"
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for the field "description"
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for the field "create"
     * @return create
     */
    public long getCreate() {
        return create;
    }

    /**
     * Setter for the field "description"
     * @param create
     */
    public void setCreate(long create) {
        this.create = create;
    }

    /**
     * Getter for the field "id"
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for the field "id"
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for the field "comments"
     * @return comments
     */
    public String[] getComments() {
        return this.comments;
    }

    /**
     * Setter for the field "comments"
     * @param comment
     */
    public void setComment(String comment) {
        for (int index = 0; index != this.comments.length; index++) {
            if (this.comments[index] == null) {
                this.comments[index] = comment;
                break;
            }
        }
    }
}
