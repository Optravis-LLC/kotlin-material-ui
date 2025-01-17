package materialui.styles

import kotlinext.js.js
import materialui.rawWithStyles
import materialui.styles.muitheme.MuiTheme
import react.*
import kotlin.reflect.KClass

fun <P: Props> withStyles(
    functionalComponent: FunctionComponent<P>,
    styleSet: StylesBuilder<P>.() -> Unit,
    withTheme: Boolean = true
): ComponentClass<P> = rawWithStyles(
    { theme: MuiTheme ->  StylesBuilder<P>(theme).apply(styleSet).css },
    js { this["withTheme"] = withTheme }
)(functionalComponent).unsafeCast<ComponentClass<P>>()

fun <P: Props> withStyles(
    rClass: ComponentClass<P>,
    styleSet: StylesBuilder<P>.() -> Unit,
    withTheme: Boolean = true
): ComponentClass<P> = rawWithStyles(
    { theme: MuiTheme -> StylesBuilder<P>(theme).apply(styleSet).css },
    js { this["withTheme"] = withTheme }
)(rClass).unsafeCast<ComponentClass<P>>()

fun <C : Component<P, *>, P : Props> withStyles(
    klazz: KClass<C>,
    styleSet: StylesBuilder<P>.() -> Unit,
    withTheme: Boolean = false
): ComponentClass<P> = withStyles(klazz.react, styleSet, withTheme = withTheme)

fun <P: Props> withStyles(
    displayName: String,
    styleSet: StylesBuilder<P>.() -> Unit,
    withTheme: Boolean = false,
    render: RBuilder.(P) -> Unit
): ComponentClass<P> = withStyles(functionComponent(displayName, render), styleSet, withTheme = withTheme)

@Deprecated(
    "Use withStyles to create a reusable ComponentClass instead, and call that to render the styled component."
)
fun <P : Props, C : Component<P, *>> RBuilder.childWithStyles(
    klazz: KClass<C>,
    styleSet: StylesBuilder<P>.() -> Unit,
    withTheme: Boolean = false,
    handler: RHandler<P>
): ReactElement {
    val rClass = withStyles(klazz, styleSet, withTheme = withTheme)

    return rClass(handler).unsafeCast<ReactElement>()
}

@Deprecated(
    "Use withStyles instead",
    replaceWith = ReplaceWith("withStyles(displayName, styleSet, withTheme, render)", "materialui.styles.withStyles")
)
fun <P: Props> RBuilder.childWithStyles(
    displayName: String,
    styleSet: StylesBuilder<P>.() -> Unit,
    withTheme: Boolean = false,
    render: RBuilder.(P) -> Unit
): ComponentClass<P> = withStyles(functionComponent(displayName, render), styleSet, withTheme = withTheme)
