package materialui.components.internal

import materialui.components.StandardProps
import org.w3c.dom.HTMLElement
import react.Props
import react.ReactElement
import react.RefObject

external interface SwitchBaseProps : StandardProps {
    var autoFocus: Boolean?
    var checked: Boolean?
    var checkedIcon: ReactElement?
    var defaultChecked: Boolean?
    var disabled: Boolean?
    var disableRipple: Boolean?
    var icon: ReactElement?
    var id: String?
    var inputProps: Props?
    var inputRef: RefObject<HTMLElement>?
    var name: String?
    var readOnly: Boolean?
    var required: Boolean?
    var tabIndex: Any?
    var type: String?
    var value: Any?
}