package materialui.pickers.components.internal.desktoppopper

import kotlinext.js.jsObject
import materialui.components.popper.PopperProps
import react.*
import kotlin.reflect.KClass

interface DesktopPopperElement<DPWProps: DesktopPopperWrapperProps> {
    @Suppress("FunctionName")
    fun DPWProps.PopperProps(block: PopperProps.() -> Unit)

    @Suppress("FunctionName")
    fun <P: Props, C: Component<P, *>> DPWProps.TransitionComponent(kClass: KClass<C>)
    @Suppress("FunctionName")
    fun <P: Props> DPWProps.TransitionComponent(functionalComponent: FunctionComponent<P>)
}

internal class DesktopPopperDelegate<DPWProps: DesktopPopperWrapperProps> : DesktopPopperElement<DPWProps> {
    override fun DPWProps.PopperProps(block: PopperProps.() -> Unit) { PopperProps = jsObject(block) }

    override fun <P: Props, C: Component<P, *>> DPWProps.TransitionComponent(kClass: KClass<C>) { TransitionComponent = kClass.react }
    override fun <P: Props> DPWProps.TransitionComponent(functionalComponent: FunctionComponent<P>) { TransitionComponent = functionalComponent }
}
