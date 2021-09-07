package materialui.styles.themeprovider

import kotlinext.js.jsObject
import materialui.styles.muitheme.MuiTheme
import react.*

class ThemeProviderBuilder internal constructor(
    val type: ComponentType<Props>,
    val theme: MuiTheme,
    private val props: Props = jsObject { }
) : RBuilderImpl() {
    init {
        props.asDynamic()["theme"] = theme
    }

    fun attrs(handler: Props.() -> Unit) {
        props.handler()
    }

    fun create() = createElement(type, props, *childList.toTypedArray())
}
