package materialui.pickers.components

import kotlinext.js.jsObject
import kotlinx.html.INPUT
import materialui.components.formhelpertext.FormHelperTextProps
import materialui.components.input.InputProps
import materialui.components.inputlabel.InputLabelProps
import materialui.components.select.SelectProps
import materialui.pickers.components.enums.PickerOrientation
import react.*
import react.dom.RDOMBuilderImpl
import react.dom.attrs
import react.dom.input
import kotlin.js.Date
import kotlin.reflect.KClass

abstract class BasePickerElementBuilder<BPProps: BasePickerProps> internal constructor(
    private val type: ComponentType<BPProps>,
    className: String?,
    props: BPProps = jsObject { }
) : RElementBuilderImpl<BPProps>(props) {
    init { props.className = className }

    fun create() = createElement(type, attrs, *childList.toTypedArray())

    fun BPProps.value(v: String?) { value = v }
    fun BPProps.value(v: Number?) { value = v }
    fun BPProps.value(v: Date?) { value = v }

    fun BPProps.onChangeFunc(block: (Any, String?) -> Unit) { onChange = block }
    fun BPProps.onAcceptFunc(block: (Any) -> Unit) { onAccept = block }
    fun BPProps.onErrorFunc(block: (Any, Any) -> Unit) { onError = block }
    fun BPProps.onOpenFunc(block: () -> Unit) { onOpen = block }
    fun BPProps.onCloseFunc(block: () -> Unit) { onClose = block }

    fun BPProps.orientation(v: PickerOrientation?) { orientation = v?.name }

    @Suppress("FunctionName")
    fun <P: ToolbarComponentProps, C: Component<P, *>> BPProps.ToolbarComponent(kClass: KClass<C>) { ToolbarComponent = kClass.react }
    @Suppress("FunctionName")
    fun <P: ToolbarComponentProps> BPProps.ToolbarComponent(functionalComponent: FunctionComponent<P>) { ToolbarComponent = functionalComponent }

    fun BPProps.toolbarTitle(block: RBuilder.() -> Unit) { toolbarTitle = buildElement(block) }

    /* DateValidationProps */
    fun BPProps.invalidDateMessage(block: RBuilder.() -> Unit) { invalidDateMessage = buildElement(block) }
    fun BPProps.minDateMessage(block: RBuilder.() -> Unit) { minDateMessage = buildElement(block) }
    fun BPProps.maxDateMessage(block: RBuilder.() -> Unit) { maxDateMessage = buildElement(block) }

    /* ExportedPickerProps */
    fun BPProps.dateRangeIcon(block: RBuilder.() -> Unit) { dateRangeIcon = buildElement(block) }
    fun BPProps.timeIcon(block: RBuilder.() -> Unit) { timeIcon = buildElement(block) }

    /* PickerWrapper */
    fun BPProps.toggleMobileKeyboardView(block: () -> Unit) { toggleMobileKeyboardView = block }

    @Suppress("FunctionName")
    fun BPProps.DateInputProps(block: DateInputProps.() -> Unit) { DateInputProps = jsObject(block) }
    fun BPProps.onDateChange(block: (Any, String, Boolean) -> Unit) { onDateChange = block }

    @Suppress("FunctionName")
    fun <P: DateInputProps, C: Component<P, *>> BPProps.KeyboardDateInputComponent(kClass: KClass<C>) { KeyboardDateInputComponent = kClass.react }
    @Suppress("FunctionName")
    fun <P: DateInputProps> BPProps.KeyboardDateInputComponent(functionalComponent: FunctionComponent<P>) { KeyboardDateInputComponent = functionalComponent }

    @Suppress("FunctionName")
    fun <P: DateInputProps, C: Component<P, *>> BPProps.PureDateInputComponent(kClass: KClass<C>) { PureDateInputComponent = kClass.react }
    @Suppress("FunctionName")
    fun <P: DateInputProps> BPProps.PureDateInputComponent(functionalComponent: FunctionComponent<P>) { PureDateInputComponent = functionalComponent }

    /* TextFieldProps */
    fun BPProps.defaultValue(v: String?) { defaultValue = v }
    fun BPProps.defaultValue(v: Number?) { defaultValue = v }
    fun BPProps.defaultValue(v: Date?) { defaultValue = v }

    @Suppress("FunctionName")
    fun BPProps.FormHelperTextProps(block: FormHelperTextProps.() -> Unit) { FormHelperTextProps = jsObject(block) }
    fun BPProps.helperText(block: RBuilder.() -> Unit) { helperText = buildElement(block) }

    @Suppress("FunctionName")
    fun BPProps.InputLabelProps(block: InputLabelProps.() -> Unit) { InputLabelProps = jsObject(block) }

    @Suppress("FunctionName")
    fun BPProps.InputProps(block: InputProps.() -> Unit) { InputProps = jsObject(block) }
    fun BPProps.inputProps(block: INPUT.() -> Unit) { inputProps = buildElement(RDOMBuilderImpl { INPUT(mapOf(), it) }) { input { attrs(block) }}.props }

    fun BPProps.label(block: RBuilder.() -> Unit) { label = buildElement(block) }

    fun BPProps.rows(v: String) { rows = v }
    fun BPProps.rows(v: Number) { rows = v }

    fun BPProps.rowsMax(v: String) { rowsMax = v }
    fun BPProps.rowsMax(v: Number) { rowsMax = v }

    @Suppress("FunctionName")
    fun BPProps.SelectProps(block: SelectProps.() -> Unit) { SelectProps = jsObject(block) }
}
