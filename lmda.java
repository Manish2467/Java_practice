import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class lmda {
    static void main() {
        Predicate<Integer> isEven = n -> n%2==0;  // yes / no ma answer dinxa

        Supplier<Integer> numberSupplier = () -> 99; // value input linxa output hudaina

        Consumer<Integer> numberConsumer = n -> System.out.println(n); // value out dinxa input hudaina

        int num = numberSupplier.get();

        if (isEven.test(num)){
            numberConsumer.accept(num);
        }
    }
}
