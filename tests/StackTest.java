import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @org.junit.jupiter.api.Test
    void push() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);

        assertSame(2, stack.peek());
    }

    @org.junit.jupiter.api.Test
    void pop() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);

        assertSame(2, stack.length());
        assertSame(2, stack.pop());
        assertSame(1, stack.length());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        Stack<Integer> stack = new Stack<>();

        assertTrue(stack.isEmpty());

        stack.push(1);

        assertFalse(stack.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        assertTrue(stack.contains((Integer i) -> i == 1));
        assertFalse(stack.contains((Integer i) -> i == 2));
    }

    @org.junit.jupiter.api.Test
    void fetch() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        assertSame(1, stack.fetch((Integer i) -> i == 1));
        assertNull(stack.fetch((Integer i) -> i == 2));
    }
}