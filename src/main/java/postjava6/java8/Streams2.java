package postjava6.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * Created by mman on 18.05.17.
 */
public class Streams2 {

    private enum Status {
        OPEN, CLOSED
    };

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }

    public static void main(String[] args) {
        final Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8)
        );

        // Calculate total points of all open tasks using sum()
        Predicate<Task> openTasks = task -> task.getStatus() == Status.OPEN;
        ToIntFunction<Task> getPoints = Task::getPoints; // or Function<Task, Integer>

        final long totalPoints = tasks
                .stream()
                .filter(openTasks)
                .mapToInt(getPoints)
                .sum();

        System.out.println("Total Points: " + totalPoints);

        IntBinaryOperator accumulator = Integer::sum;
        final long altTotalPoints = tasks
                .stream()
                .parallel()
                .mapToInt(task -> task.getPoints())
                .reduce(1, accumulator);

        System.out.println("Total Points: " + altTotalPoints);

        final Map<Status, List<Task>> tasksByStatus = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getStatus));

        System.out.println(tasksByStatus);

        // Calculate the weight of each tasks (as percent of total points)
        final Collection< String > result = tasks
                .stream()                                           // Stream<String>
                .mapToInt( Task::getPoints )
                .asLongStream()
                .mapToDouble( points -> points / totalPoints )
                .boxed()                                            // Stream<Double>
                .mapToLong( weigth -> ( long )( weigth * 100 ) )
                .mapToObj( percentage -> percentage + "%" )         // Stream<String>
                .collect(Collectors.toList());                      // List<String>

        System.out.println("Result: " + result);
    }
}
