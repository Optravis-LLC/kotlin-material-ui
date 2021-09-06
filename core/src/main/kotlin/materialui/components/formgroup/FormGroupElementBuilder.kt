package materialui.components.formgroup

import kotlinx.html.DIV
import kotlinx.html.Tag
import materialui.components.MaterialElementBuilder
import materialui.components.formgroup.enums.FormGroupStyle
import materialui.components.getValue
import materialui.components.setValue
import react.ComponentType

open class FormGroupElementBuilder<P: FormGroupProps> internal constructor(
    type: ComponentType<P>,
    classMap: List<Pair<Enum<*>, String>>
) : MaterialElementBuilder<DIV, P>(type, classMap, { DIV(mapOf(), it) }) {
    fun Tag.classes(vararg classMap: Pair<FormGroupStyle, String>) {
        classes(classMap.toList())
    }

    var Tag.row: Boolean? by materialProps
}