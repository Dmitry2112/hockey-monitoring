package examples.patterns.behavior.memento;

public class Usage {
    public static void main(String[] args) {
        Repo repo = new Repo();
        Project project = new Project();

        String racketCode =
                """
                (define (sum a b)
                    (+ a b))
                
                (displayln (sum 2 3))
                """;

        project.writeCode(racketCode);
        Integer hash = repo.save(project);

        System.out.println("Первая версия проекта");
        System.out.println(project);
        System.out.println("**********************\n");

        String racketCode2 =
                """
                (define (sub a b)
                    (- a b))
                
                (displayln (sub 6 4))
                """;

        project.writeCode(racketCode2);

        System.out.println("Вторая версия проекта");
        System.out.println(project);
        System.out.println("**********************\n");

        repo.load(project, hash);

        System.out.println("Откат к первой версии проекта");
        System.out.println(project);
        System.out.println("**********************\n");
    }
}
