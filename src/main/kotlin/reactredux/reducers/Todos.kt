package reactredux.reducers

import reactredux.actions.AddTodo
import reactredux.actions.DeleteTodo
import reactredux.actions.EditTodo
import reactredux.actions.ToggleTodo
import reactredux.entities.Todo
import redux.RAction

fun todos(state: Array<Todo> = emptyArray(), action: RAction): Array<Todo> = when (action) {
    is AddTodo -> {
        val newId = if (state.isEmpty()) 1 else state.last().id + 1
        state + Todo(newId, action.text, false)
    }
    is ToggleTodo -> state.map {
        if (it.id == action.id) {
            it.copy(completed = !it.completed)
        } else {
            it
        }
    }.toTypedArray()
    is DeleteTodo -> state.filterNot { it.id == action.id }.toTypedArray()
    is EditTodo -> state.map {
        if(it.id == action.id) {
            it.copy(text = action.newText)
        } else {
            it
        }
    }.toTypedArray()
    else -> state
}
