package materialui.components.slide

import materialui.Slide
import materialui.reacttransiton.RTransitionProps
import materialui.styles.muitheme.MuiTheme
import react.RBuilder
import react.Props

external interface SlideProps : RTransitionProps, Props {
    var style: Any?
    var theme: MuiTheme?
}

fun RBuilder.slide(block: SlideElementBuilder.() -> Unit)
    = child(SlideElementBuilder(Slide).apply(block).create())
