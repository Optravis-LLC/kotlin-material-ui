package materialui.components.tablesortlabel

import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import materialui.components.buttonbase.ButtonBaseElementBuilder
import materialui.components.getValue
import materialui.components.setValue
import materialui.components.tablesortlabel.enums.TableSortLabelDirection
import react.*
import kotlin.reflect.KClass

class TableSortLabelElementBuilder<T: Tag> internal constructor(
    type: ComponentType<TableSortLabelProps>,
    classMap: List<Pair<Enum<*>, String>>,
    factory: (TagConsumer<Unit>) -> T
) : ButtonBaseElementBuilder<T, TableSortLabelProps>(type, classMap, factory) {

    var Tag.active: Boolean? by materialProps
    var Tag.direction: TableSortLabelDirection? by materialProps
    var Tag.hideSortIcon: Boolean? by materialProps

    fun <P : Props, C : Component<P, *>> Tag.iconComponent(kClass: KClass<C>) {
        @Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
        @Suppress("UNCHECKED_CAST")
        materialProps.IconComponent = kClass.js as ComponentClass<P>
    }
    fun Tag.iconComponent(tagName: String) {
        materialProps.IconComponent = tagName
    }
}