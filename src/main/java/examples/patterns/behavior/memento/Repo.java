package examples.patterns.behavior.memento;

import examples.patterns.behavior.memento.Project.Commit;

import java.util.HashMap;
import java.util.Map;

public class Repo {
    private final Map<Integer, Commit> commits = new HashMap<>();

    public Integer save(Project project) {
        Commit commit = project.createCommit();
        Integer hash = commit.hashCode();
        commits.put(hash, commit);
        return hash;
    }

    public void load(Project project, Integer hash) {
        if (commits.containsKey(hash)) {
            Commit commit = commits.get(hash);
            project.setCommit(commit);
        }
    }
}
