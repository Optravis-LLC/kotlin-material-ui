package materialui.components.tooltip

import materialui.Tooltip
import materialui.components.StandardProps
import materialui.components.tooltip.enums.TooltipPlacement
import materialui.components.tooltip.enums.TooltipStyle
import materialui.reacttransiton.RTransitionProps
import org.w3c.dom.events.Event
import react.Props
import react.RBuilder
import react.ReactElement

external interface TooltipProps : StandardProps {
    var disableFocusListener: Boolean?
    var disableHoverListener: Boolean?
    var disableTouchListener: Boolean?
    var enterDelay: Number?
    var enterTouchDelay: Number?
    var id: String?
    var interactive: Boolean?
    var leaveDelay: Number?
    var leaveTouchDelay: Number?
    var onClose: ((Event) -> Unit)?
    var onOpen: ((Event) -> Unit)?
    var open: Boolean?
    var PopperProps: Props?
    var theme: Any?
    var title: ReactElement?
    var TransitionComponent: dynamic
    var TransitionProps: RTransitionProps?
}

var TooltipProps.placement: TooltipPlacement?
    get() = (asDynamic()["placement"] as String?)?.let { TooltipPlacement.valueOf(it) }
    set(value) { asDynamic()["placement"] = value?.toString() }

fun RBuilder.tooltip(vararg classMap: Pair<TooltipStyle, String>, block: TooltipElementBuilder.() -> Unit)
    = child(TooltipElementBuilder(Tooltip, classMap.toList()).apply(block).create())
