package workshop.tdd.todo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestTodoHolder {

    @Test
    void ensureTodoWillBeAddedToTodoList() {
        // Arrange
        TodoHolder holder = new TodoHolder();
        String newTodo = "Cleanup Desk";

        // Act
        boolean result = holder.addTodo(newTodo);

        // Assert
        assertAll("Should get the added Todo List",
                () -> assertTrue(result),
                () -> assertEquals(1, holder.todoList.size()),
                () -> assertEquals(newTodo, holder.todoList.get(0))
        );
    }

    @Test
    void ensureTodoWillBeAddedToAlreadyUsedTodoList() {
        //Arrange
        TodoHolder holder = new TodoHolder(new ArrayList<String>() {{
            add("Cleanup Desk");
        }});
        String newTodo = "Do Homework";

        // Act
        boolean result = holder.addTodo(newTodo);

        // Assert
        assertAll("Should get the added Todo and the previous Todo",
                () -> assertTrue(result),
                () -> assertEquals(2, holder.todoList.size()),
                () -> assertEquals(newTodo, holder.todoList.get(holder.todoList.size() - 1))
        );
    }

    @Test
    void ensureAddingEmptyTodoWillReturnFalse() {
        // Arrange
        TodoHolder holder = new TodoHolder();

        // Act
        boolean result = holder.addTodo("");

        // Assert
        assertFalse(result);
    }

    @Test
    void ensureAddingNullTodoWillReturnFalse() {
        // Arrange
        TodoHolder holder = new TodoHolder();

        // Act
        boolean result = holder.addTodo(null);

        // Assert
        assertFalse(result);
    }

    @Test
    void ensureAddingBlankTodoWillReturnFalse() {
        // Arrange
        TodoHolder holder = new TodoHolder();

        // Act
        boolean result = holder.addTodo("   ");

        // Assert
        assertFalse(result);
    }
}
