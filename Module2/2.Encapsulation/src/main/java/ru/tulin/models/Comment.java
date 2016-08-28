package ru.tulin.models;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */
public class Comment {

    private String comment;

    public Comment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment1 = (Comment) o;

        return comment != null ? comment.equals(comment1.comment) : comment1.comment == null;

    }

    @Override
    public int hashCode() {
        return comment != null ? comment.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment='" + comment + '\'' +
                '}';
    }
}
