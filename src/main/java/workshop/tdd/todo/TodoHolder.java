package workshop.tdd.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoHolder {
    public List<String> todoList;

    public TodoHolder() {
        todoList = new ArrayList<>();
    }

    /**
     * Add a To-do to the list
     * @param todo Todo to add
     * @return true if successfully added, false if there was an error
     */
    public boolean addTodo(String todo) {
        todoList.add(todo);
        return true;
    }
}
