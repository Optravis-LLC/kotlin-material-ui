package materialui.components.nossr

import materialui.NoSsr
import react.RBuilder
import react.Props
import react.ReactElement

external interface NoSsrProps : Props {
    var defer: Boolean?
    var fallback: ReactElement?
}

fun RBuilder.noSsr(block: NoSsrElementBuilder.() -> Unit)
    = child(NoSsrElementBuilder(NoSsr).apply(block).create())
