package com.gorillalogic.miguelhincapie.accessibilitycases.ui.util

/**
 * Copyright 2020 [Miguel Hincapie C]
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * https://stackoverflow.com/users/1332549/miguelhincapiec
 * https://github.com/miguelhincapie
 * https://www.linkedin.com/in/miguelhincapie/
 */
import android.view.View
import android.widget.Button
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.gorillalogic.miguelhincapie.accessibilitycases.R
import com.gorillalogic.miguelhincapie.accessibilitycases.ui.viewmodel.TalkBackState

/**
 * Extension function to disable a Button.
 * Workaround due we can't just set enable to false because it will lose focusable ability.
 * Check canTakeFocus() function inside View.java file.
 */
fun Button.disable(@DrawableRes drawableForAccessibility: Int) {
    if (TalkBackState.value == true) {
        isEnabled = true
        isClickable = false
        contentDescription = String.format(context.getString(R.string.button_disabled_accessibility), text)
        background = ContextCompat.getDrawable(context, drawableForAccessibility)
    } else {
        isEnabled = false
    }
}

/**
 * Extension function to enable a Button.
 * Workaround due we can't just set enable to false because it will lose focusable ability.
 * Check canTakeFocus() function inside View.java file.
 */
fun Button.enable(@DrawableRes drawableForAccessibility: Int) {
    if (TalkBackState.value == true) {
        isEnabled = true
        isClickable = true
        contentDescription = context.getString(R.string.button_accessibility_label, text)
        background = ContextCompat.getDrawable(context, drawableForAccessibility)
    } else {
        isEnabled = true
    }
}

/**
 * Extension function to set touch values for accessibility
 */
fun List<View>.enableAccessibilityFocus() {
    this.forEach {
        it.setAccessibilityFocus()
    }
}

/**
 * Extension function to remove touch values for accessibility
 */
fun List<View>.disableAccessibilityFocus() {
    this.forEach {
        it.setAccessibilityFocus(false)
    }
}

/**
 * Extension function to set touch/remove values for accessibility depends on params value
 */
fun View.setAccessibilityFocus(value: Boolean = true) {
    this.isFocusableInTouchMode = value
    this.isFocusable = value
}