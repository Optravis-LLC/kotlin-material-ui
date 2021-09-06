package materialui.reacteventlistener

import kotlinext.js.jsObject
import react.*

abstract class REventListenerBuilder<P: Props> internal constructor(
    val type: ComponentType<P>,
    protected val props: P = jsObject { }
) : RBuilderImpl() {
    fun attrs(handler: P.() -> Unit) {
        props.handler()
    }

    fun create() = createElement(type, props, *childList.toTypedArray())
}