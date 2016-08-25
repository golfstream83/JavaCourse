package ru.tulin.templates;

/**
 * Created by Tulin Victor on 11.08.2016.
 */
public abstract class TemplateAction {

    abstract void start();
    abstract void finish();

    public void work() {
        this.start();
        this.finish();
    }
}
