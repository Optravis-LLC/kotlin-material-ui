package materialui.components.zoom

import materialui.Zoom
import materialui.reacttransiton.RTransitionProps
import materialui.styles.muitheme.MuiTheme
import react.RBuilder
import react.Props

external interface ZoomProps : RTransitionProps, Props {
    var style: Any?
    var theme: MuiTheme?
}

fun RBuilder.zoom(block: ZoomElementBuilder.() -> Unit)
    = child(ZoomElementBuilder(Zoom).apply(block).create())
