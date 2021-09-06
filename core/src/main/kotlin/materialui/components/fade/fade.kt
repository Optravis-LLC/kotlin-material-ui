package materialui.components.fade

import materialui.Fade
import materialui.reacttransiton.RTransitionProps
import react.RBuilder
import react.Props

external interface FadeProps : RTransitionProps, Props

fun RBuilder.fade(block: FadeElementBuilder.() -> Unit)
    = child(FadeElementBuilder(Fade).apply(block).create())
