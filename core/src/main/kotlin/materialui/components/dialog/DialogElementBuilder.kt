package materialui.components.dialog

import kotlinext.js.js
import kotlinext.js.jsObject
import kotlinx.html.DIV
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import materialui.components.dialog.enums.DialogMaxWidth
import materialui.components.dialog.enums.DialogScroll
import materialui.components.dialog.enums.DialogStyle
import materialui.components.getValue
import materialui.components.modal.ModalElementBuilder
import materialui.components.paper.PaperElementBuilder
import materialui.components.paper.PaperProps
import materialui.components.paper.paper
import materialui.components.setValue
import materialui.reacttransiton.RTransitionProps
import react.*
import kotlin.reflect.KClass

class DialogElementBuilder internal constructor(
    type: ComponentType<DialogProps>,
    classMap: List<Pair<Enum<*>, String>>
) : ModalElementBuilder<DialogProps>(type, classMap) {
    fun Tag.classes(vararg classMap: Pair<DialogStyle, String>) {
        classes(classMap.toList())
    }

    var Tag.fullScreen: Boolean? by materialProps
    var Tag.fullWidth: Boolean? by materialProps
    var Tag.maxWidth: DialogMaxWidth? by materialProps
    var Tag.PaperProps: Props? by materialProps
    var Tag.scroll: DialogScroll? by materialProps
    var Tag.TransitionProps: Props? by materialProps

    fun <P: Props, C: Component<P, *>> Tag.paperComponent(kClass: KClass<C>) {
        materialProps.PaperComponent = kClass.react
    }

    fun <P: PaperProps> Tag.paperComponent(component: FunctionComponent<P>) {
        materialProps.PaperComponent = component
    }

    fun Tag.paperComponent(tagName: String) { materialProps.PaperComponent = tagName }
    fun Tag.paperProps(block: PaperElementBuilder<DIV, PaperProps>.() -> Unit) {
        PaperProps = buildElement { paper(block = block) }.props
    }
    fun <T: Tag, P: PaperProps> Tag.paperProps(factory: (TagConsumer<Unit>) -> T, block: PaperElementBuilder<T, P>.() -> Unit) {
        PaperProps = buildElement { paper(factory = factory, block = block) }.props
    }
    fun Tag.transitionDuration(duration: Number) { materialProps.transitionDuration = duration }
    fun Tag.transitionDuration(enter: Number? = null, exit: Number? = null) { materialProps.transitionDuration = js { this["enter"] = enter; this["end"] = exit } }
    fun <P: Props, C: Component<P, *>> Tag.transitionComponent(kClass: KClass<C>) {
        @Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
        @Suppress("UNCHECKED_CAST")
        materialProps.TransitionComponent = kClass.js as ComponentClass<P>
    }
    fun Tag.transitionComponent(tagName: String) { materialProps.TransitionComponent = tagName }
    fun Tag.transitionProps(block: RTransitionProps.() -> Unit) { TransitionProps = jsObject(block) }
}