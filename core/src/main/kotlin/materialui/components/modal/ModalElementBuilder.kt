package materialui.components.modal

import kotlinext.js.jsObject
import kotlinx.html.DIV
import kotlinx.html.Tag
import materialui.components.MaterialElementBuilder
import materialui.components.backdrop.BackdropElementBuilder
import materialui.components.backdrop.backdrop
import materialui.components.getValue
import materialui.components.modal.enums.ModalStyle
import materialui.components.setValue
import org.w3c.dom.HTMLElement
import org.w3c.dom.Node
import org.w3c.dom.events.Event
import react.*
import kotlin.reflect.KClass

open class ModalElementBuilder<P: ModalProps>(
    type: ComponentType<P>,
    classMap: List<Pair<Enum<*>, String>>
) : MaterialElementBuilder<DIV, P>(type, classMap, { DIV(mapOf(), it) }) {
    fun Tag.classes(vararg classMap: Pair<ModalStyle, String>) {
        classes(classMap.toList())
    }

    var Tag.BackdropProps: Props? by materialProps
    var Tag.disableAutoFocus: Boolean? by materialProps
    var Tag.disableBackdropClick: Boolean? by materialProps
    var Tag.disableEnforceFocus: Boolean? by materialProps
    var Tag.disableEscapeKeyDown: Boolean? by materialProps
    var Tag.disablePortal: Boolean? by materialProps
    var Tag.disableRestoreFocus: Boolean? by materialProps
    var Tag.hideBackdrop: Boolean? by materialProps
    var Tag.keepMounted: Boolean? by materialProps
    var Tag.onBackdropClick: ((Event) -> Unit)? by materialProps
    var Tag.onClose: ((Event, String) -> Unit)? by materialProps
    var Tag.onEscapeKeyDown: ((Event) -> Unit)? by materialProps
    var Tag.onRendered: (() -> Unit)? by materialProps
    var Tag.open: Boolean? by materialProps

    fun <P : Props, C : Component<P, *>> Tag.backdropComponent(kClass: KClass<C>) {
        @Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
        @Suppress("UNCHECKED_CAST")
        materialProps.BackdropComponent = kClass.js as ComponentClass<P>
    }
    fun Tag.backdropComponent(tagName: String) { materialProps.BackdropComponent = tagName }
    fun Tag.backdropProps(block: BackdropElementBuilder.() -> Unit) {
        BackdropProps = buildElement { backdrop(block = block) }.props
    }
    fun <P: Props> Tag.backdropProps(block: P.() -> Unit) { BackdropProps = jsObject(block) }
    fun Tag.container(node: Node) { materialProps.container = node }
    fun Tag.container(htmlElement: HTMLElement) { materialProps.container = htmlElement }
    fun Tag.container(block: RBuilder.() -> Unit) { materialProps.container = buildElement(block) }
}