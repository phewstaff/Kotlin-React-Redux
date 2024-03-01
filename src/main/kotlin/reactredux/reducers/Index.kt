package reactredux.reducers

import reactredux.entities.Todo
import reactredux.enums.VisibilityFilter
import reactredux.utils.loadStateFromLocalStorage
import redux.RAction

val PersistedState = loadStateFromLocalStorage()

data class State(
        val todos: Array<Todo> = PersistedState,
        val visibilityFilter: VisibilityFilter = VisibilityFilter.SHOW_ALL
)

fun rootReducer(
    state: State,
    action: Any
) = State(
    todos(state.todos, action.unsafeCast<RAction>()),
    visibilityFilter(state.visibilityFilter, action.unsafeCast<RAction>()),
)