package examples.patterns.behavior.memento;

public class Project {
    private String code = "";

    public void writeCode(String code) {
        this.code += "\n" + code;
    }

    public String toString() {
        return code;
    }

    public Commit createCommit() {
        Commit commit = new Commit();
        commit.setState(this);
        return commit;
    }

    public void setCommit(Commit commit) {
        this.code = commit.getCode();
    }

    /**
     * паттерн Memento
     */
    public static class Commit {
        private String code;

        private Commit() {}

        private String getCode() {
            return code;
        }

        private void setState(Project project) {
            this.code = project.code;
        }
    }
}
