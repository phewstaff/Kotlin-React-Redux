package reactredux.entities

import kotlinx.serialization.Serializable

@Serializable
data class Todo(val id: Int, val text: String, var completed: Boolean)