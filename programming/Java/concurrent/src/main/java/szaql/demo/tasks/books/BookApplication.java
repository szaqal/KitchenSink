package szaql.demo.tasks.books;

import java.util.concurrent.*;

public class BookApplication {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);


    public static void main(String[]args) {
        try {
            CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
            int taskCount = new BookRepository()
                    .getBookList()
                    .stream()
                    .map(PullBookTask::new).map(completionService::submit)
                    .toList()
                    .size();

            for (int i = 0; i < taskCount; i++) {
                String content = completionService.take().get();
                System.out.println(content);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}
