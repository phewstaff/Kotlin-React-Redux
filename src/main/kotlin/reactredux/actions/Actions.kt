package reactredux.actions

import reactredux.enums.VisibilityFilter
import redux.RAction

class SetVisibilityFilter(val filter: VisibilityFilter) : RAction

class AddTodo(val text: String): RAction
class ToggleTodo(val id: Int): RAction
class DeleteTodo(val id: Int): RAction
class EditTodo(val id: Int, val newText: String): RAction