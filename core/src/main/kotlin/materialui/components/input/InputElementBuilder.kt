package materialui.components.input

import kotlinx.html.Tag
import materialui.components.getValue
import materialui.components.input.enums.InputStyle
import materialui.components.inputbase.InputBaseElementBuilder
import materialui.components.setValue
import react.ComponentType

open class InputElementBuilder<P: InputProps> internal constructor(
    type: ComponentType<P>,
    classMap: List<Pair<Enum<*>, String>>
) : InputBaseElementBuilder<P>(type, classMap) {
    fun Tag.classes(vararg classMap: Pair<InputStyle, String>) {
        classes(classMap.toList())
    }

    var Tag.disableUnderline: Boolean? by materialProps
}