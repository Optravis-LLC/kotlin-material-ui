package materialui

import react.RComponent
import react.Props

internal typealias MakeStyles = (Props) -> dynamic
internal typealias WithStyles = (Any) -> RComponent<dynamic, dynamic>
