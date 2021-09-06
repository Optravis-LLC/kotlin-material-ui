package materialui.components.rootref

import materialui.RootRef
import org.w3c.dom.HTMLElement
import react.*

external interface RootRefProps : Props {
    var rootRef: RefObject<HTMLElement>?
}

fun RBuilder.rootRef(block: RootRefElementBuilder.() -> Unit)
    = child(RootRefElementBuilder(RootRef).apply(block).create())
