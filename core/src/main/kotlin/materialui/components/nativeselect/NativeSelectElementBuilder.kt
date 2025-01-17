package materialui.components.nativeselect

import kotlinx.html.Tag
import materialui.components.getValue
import materialui.components.input.InputElementBuilder
import materialui.components.nativeselect.enums.NativeSelectStyle
import materialui.components.nativeselect.enums.NativeSelectVariant
import materialui.components.setValue
import react.*
import react.dom.setProp
import kotlin.reflect.KClass

class NativeSelectElementBuilder internal constructor(
    type: ComponentType<NativeSelectProps>,
    classMap: List<Pair<Enum<*>, String>>
) : InputElementBuilder<NativeSelectProps>(type, classMap) {
    fun Tag.classes(vararg classMap: Pair<NativeSelectStyle, String>) {
        classes(classMap.toList())
    }

    var Tag.iconComponent: RComponent<Props, State>
        get() = @Suppress("UnsafeCastFromDynamic") domProps.asDynamic()["IconComponent"]
        set(value) { setProp("IconComponent", value) }
    var Tag.input: ReactElement? by materialProps
    var Tag.variant: NativeSelectVariant? by materialProps

    fun <P : Props, C : Component<P, *>> Tag.iconComponent(kClass: KClass<C>) {
        @Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
        @Suppress("UNCHECKED_CAST")
        materialProps.IconComponent = kClass.js as ComponentClass<P>
    }
    fun Tag.iconComponent(tagName: String) { materialProps.IconComponent = tagName }
}