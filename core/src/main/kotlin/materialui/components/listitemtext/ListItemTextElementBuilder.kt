package materialui.components.listitemtext

import kotlinx.html.*
import materialui.components.MaterialElementBuilder
import materialui.components.getValue
import materialui.components.listitemtext.enums.ListItemTextStyle
import materialui.components.setValue
import materialui.components.typography.TypographyElementBuilder
import materialui.components.typography.TypographyProps
import materialui.components.typography.typography
import materialui.styles.muitheme.MuiTheme
import react.*

class ListItemTextElementBuilder internal constructor(
    type: ComponentType<ListItemTextProps>,
    classMap: List<Pair<Enum<*>, String>>
) : MaterialElementBuilder<DIV, ListItemTextProps>(type, classMap, { DIV(mapOf(), it) }) {
    fun Tag.classes(vararg classMap: Pair<ListItemTextStyle, String>) {
        classes(classMap.toList())
    }

    var Tag.disableTypography: Boolean? by materialProps
    var Tag.inset: Boolean? by materialProps
    var Tag.primary: ReactElement? by materialProps
    var Tag.primaryTypographyProps: Props? by materialProps
    var Tag.secondary: ReactElement? by materialProps
    var Tag.secondaryTypographyProps: Props? by materialProps
    var Tag.theme: MuiTheme? by materialProps

    fun Tag.primary(block: TypographyElementBuilder<SPAN, TypographyProps>.() -> Unit) { primary = buildElement { typography(block = block) }  }
    fun Tag.primary(p: Boolean, block: TypographyElementBuilder<P, TypographyProps>.() -> Unit) { primary = buildElement { typography(p = p, block = block) }  }
    fun <T: Tag> Tag.primary(factory: (TagConsumer<Unit>) -> T, block: TypographyElementBuilder<T, TypographyProps>.() -> Unit) { primary = buildElement { typography(factory = factory, block = block) }  }
    fun Tag.primaryTypographyProps(block: TypographyElementBuilder<SPAN, TypographyProps>.() -> Unit) {
        primaryTypographyProps = buildElement { typography(block = block) }.props
    }
    fun Tag.secondary(block: TypographyElementBuilder<SPAN, TypographyProps>.() -> Unit) { secondary = buildElement { typography(block = block) }  }
    fun Tag.secondary(p: Boolean, block: TypographyElementBuilder<P, TypographyProps>.() -> Unit) { secondary = buildElement { typography(p = p, block = block) }  }
    fun <T: Tag> Tag.secondary(factory: (TagConsumer<Unit>) -> T, block: TypographyElementBuilder<T, TypographyProps>.() -> Unit) { secondary = buildElement { typography(factory = factory, block = block) }  }
    fun Tag.secondaryTypographyProps(block: TypographyElementBuilder<SPAN, TypographyProps>.() -> Unit) {
        secondaryTypographyProps = buildElement { typography(block = block) }.props
    }
}