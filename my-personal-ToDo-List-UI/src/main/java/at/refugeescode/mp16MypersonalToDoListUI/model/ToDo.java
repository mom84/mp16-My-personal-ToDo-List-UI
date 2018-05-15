package at.refugeescode.mp16MypersonalToDoListUI.model;

public class ToDo {

    private String id;

    private String task;

    private boolean done;

    public ToDo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public ToDo(String task) {

        this.id = id;

        this.task = task;
        this.done = done;
    }


    @Override
    public String toString() {
        return "ToDo{" +
                "id='" + id + '\'' +
                ", task='" + task + '\'' +
                ", done=" + done +
                '}';
    }
}
