package materialui.components.drawer

import kotlinext.js.js
import kotlinx.html.DIV
import kotlinx.html.Tag
import materialui.components.MaterialElementBuilder
import materialui.components.drawer.enums.DrawerAnchor
import materialui.components.drawer.enums.DrawerStyle
import materialui.components.drawer.enums.DrawerVariant
import materialui.components.getValue
import materialui.components.setValue
import materialui.styles.muitheme.MuiTheme
import org.w3c.dom.events.Event
import react.ComponentType
import react.Props

open class DrawerElementBuilder<P: DrawerProps> internal constructor(
    type: ComponentType<P>,
    classMap: List<Pair<Enum<*>, String>>
) : MaterialElementBuilder<DIV,P>(type, classMap, { DIV(mapOf(), it) }) {
    fun Tag.classes(vararg classMap: Pair<DrawerStyle, String>) {
        classes(classMap.toList())
    }

    var Tag.anchor: DrawerAnchor? by materialProps
    var Tag.BackdropProps: Props? by materialProps
    var Tag.elevation: Number? by materialProps
    var Tag.ModalProps: Props? by materialProps
    var Tag.onClose: ((Event) -> Unit)? by materialProps
    var Tag.open: Boolean? by materialProps
    var Tag.PaperProps: Props? by materialProps
    var Tag.SlideProps: Props? by materialProps
    var Tag.theme: MuiTheme? by materialProps
    var Tag.variant: DrawerVariant? by materialProps

    fun Tag.transitionDuration(msec: Number) { materialProps.transitionDuration = msec }
    fun Tag.transitionDuration(start: Number? = null, exit: Number? = null) { materialProps.transitionDuration = js { this["start"] = start; this["exit"] = exit } }
}