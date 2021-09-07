package materialui.pickers.components

import react.Props

external interface DateValidationProps : Props {
    var invalidDateMessage: dynamic
    var minDateMessage: dynamic
    var maxDateMessage: dynamic
    var strictCompareDate: Boolean?
}
