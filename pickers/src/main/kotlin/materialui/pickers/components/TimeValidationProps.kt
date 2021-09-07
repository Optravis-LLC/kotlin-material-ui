package materialui.pickers.components

import react.Props

external interface TimeValidationProps : Props {
    var minTime: dynamic
    var maxTime: dynamic
    var shouldDisableTime: ((Number, String) -> Boolean)?
    var disableTimeValidationIgnoreDatePart: Boolean?
}
