package mar24;

public class serialization {
    private String name,job, createAt;
    private int id;

    public serialization(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getCreateAt() {
        return createAt;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "serialization{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", createAt='" + createAt + '\'' +
                ", id=" + id +
                '}';
    }
}
