package reactredux.utils

import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import reactredux.entities.Todo


fun loadStateFromLocalStorage(): Array<Todo> {
    val todosJson = window.localStorage.getItem("todos")
    return todosJson?.let {
        try {
            Json.decodeFromString<Array<Todo>>(it)
        } catch (e: Throwable) {
            console.error("Error serializing todos: ${e.message}")
            emptyArray()
        }
    } ?: emptyArray()
}

fun saveState(todos: Array<Todo>) {
    try {
        val todosJson = Json.encodeToString(todos)
        window.localStorage.setItem("todos", todosJson)
    } catch (e: Throwable) {
        console.error("Error serializing todos: ${e.message}")
    }
}
