package com.gorillalogic.miguelhincapie.accessibilitycases.accessibility.delegate

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
import android.view.KeyEvent.*
import android.view.View
import com.gorillalogic.miguelhincapie.accessibilitycases.R
import com.gorillalogic.miguelhincapie.accessibilitycases.ui.util.*
import com.gorillalogic.miguelhincapie.domain.accessibility.BaseKeyEventDelegate
import com.gorillalogic.miguelhincapie.domain.accessibility.createKey

class GridKeyEventDelegate : BaseKeyEventDelegate() {

    init {
        keyEventActionMap.let {
            it.put(
                createKey(
                    R.id.grid_element_item,
                    KEYCODE_DPAD_DOWN
                ),
                this::consumeDownKeyOnGrid
            )
            it.put(
                createKey(
                    R.id.grid_element_item,
                    KEYCODE_DPAD_UP
                ),
                this::consumeUpKeyOnGrid
            )
            it.put(
                createKey(
                    R.id.grid_element_item,
                    KEYCODE_DPAD_LEFT
                ),
                this::consumeLeftKeyOnGrid
            )
            it.put(
                createKey(
                    R.id.grid_element_item,
                    KEYCODE_DPAD_RIGHT
                ),
                this::consumeRightKeyOnGrid
            )
        }
    }

    private fun consumeDownKeyOnGrid(currentFocus: View): Boolean = with(currentFocus) {
        getNextElementPosition().let { nextElementPosition ->
            if (isPositionInbound(nextElementPosition)) {
                sendFocusToListItem(nextElementPosition)
            } else {
                rootView.findViewById<View>(R.id.carousel_container)?.sendAccessibilityFocus()
            }
        }
        return true
    }

    private fun consumeUpKeyOnGrid(currentFocus: View): Boolean = with(currentFocus) {
        getPreviousElementPosition().let { previousElementPosition ->
            if (isPositionInbound(previousElementPosition)) {
                sendFocusToListItem(previousElementPosition)
            } else {
                rootView.findViewById<View>(R.id.accessibility_state)
                    ?.sendAccessibilityFocus(View.FOCUS_UP)
            }
        }
        return true
    }

    private fun consumeLeftKeyOnGrid(currentFocus: View): Boolean {
        return true
    }

    private fun consumeRightKeyOnGrid(currentFocus: View): Boolean {
        return true
    }
}