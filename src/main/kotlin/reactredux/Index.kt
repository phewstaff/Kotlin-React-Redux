package reactredux

import reactredux.components.app
import reactredux.reducers.State
import react.dom.render
import react.redux.provider
import redux.createStore
import redux.rEnhancer
import kotlinx.browser.document
import reactredux.reducers.rootReducer
import reactredux.utils.saveState


val store = createStore(::rootReducer, State(), rEnhancer())

fun main() {
    store.subscribe {
    saveState(store.getState().todos)
    }

    val rootDiv = document.getElementById("root")!!
    render(rootDiv) {
        provider(store) {
            app()
        }
    }
}
