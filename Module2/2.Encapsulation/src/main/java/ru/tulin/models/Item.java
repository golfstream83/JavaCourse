package ru.tulin.models;

import java.util.Arrays;
import java.util.Date;

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
        this.create = new Date().getTime();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.name.hashCode();
        result = prime * result + this.description.hashCode();
        result = prime * result + (int) this.create;
        result = prime * result + this.id.hashCode();
        result = prime * result + Arrays.deepHashCode(this.comments);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Item other = (Item) obj;
        if (this.name != other.name)
            return false;
        if (this.description != other.description)
            return false;
        if (this.create != other.create)
            return false;
        if (this.id != other.id)
            return false;
        if (!Arrays.deepEquals(this.comments, other.comments))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", create=" + create +
                ", id='" + id + '\'' +
                ", comments=" + Arrays.toString(comments) +
                '}';
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
