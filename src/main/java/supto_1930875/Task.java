package supto_1930875;

import javafx.beans.property.SimpleStringProperty;

public class Task {
    private final SimpleStringProperty taskName;
    private final SimpleStringProperty progress;

    public Task(String taskName, String progress) {
        this.taskName = new SimpleStringProperty(taskName);
        this.progress = new SimpleStringProperty(progress);
    }

    public String getTaskName() {
        return taskName.get();
    }

    public SimpleStringProperty taskNameProperty() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName.set(taskName);
    }

    public String getProgress() {
        return progress.get();
    }

    public SimpleStringProperty progressProperty() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress.set(progress);
    }
}