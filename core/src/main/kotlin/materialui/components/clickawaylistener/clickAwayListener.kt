package materialui.components.clickawaylistener

import materialui.ClickAwayListener
import org.w3c.dom.events.Event
import react.RBuilder
import react.Props

external interface ClickAwayListenerProps : Props {
    var mouseEvent: dynamic
    var onClickAway: ((Event) -> Unit)?
    var touchEvent: dynamic
}

fun RBuilder.clickAwayListener(block: ClickAwayListenerBuilder.() -> Unit)
    = child(ClickAwayListenerBuilder(ClickAwayListener).apply(block).create())
