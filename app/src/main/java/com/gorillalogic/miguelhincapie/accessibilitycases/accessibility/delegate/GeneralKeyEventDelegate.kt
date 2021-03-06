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
import androidx.recyclerview.widget.RecyclerView
import com.gorillalogic.miguelhincapie.accessibilitycases.R
import com.gorillalogic.miguelhincapie.accessibilitycases.ui.util.sendFocusToFirstElement
import com.gorillalogic.miguelhincapie.domain.accessibility.BaseKeyEventDelegate
import com.gorillalogic.miguelhincapie.domain.accessibility.createKey

class GeneralKeyEventDelegate : BaseKeyEventDelegate() {

    init {
        keyEventActionMap.let {
            it.put(
                createKey(
                    R.id.accessibility_state,
                    KEYCODE_DPAD_DOWN
                ),
                this::consumeDownKeyOnTitle
            )
            it.put(
                createKey(
                    R.id.button_turn_on,
                    KEYCODE_DPAD_DOWN
                ),
                this::consumeDownKeyOnTurnOnButton
            )
            it.put(
                createKey(
                    R.id.button_turn_on,
                    KEYCODE_DPAD_UP
                ),
                this::consumeUpKeyOnTurnOnButton
            )
            it.put(
                createKey(
                    R.id.button_turn_off,
                    KEYCODE_DPAD_UP
                ),
                this::consumeUpKeyOnTurnOffButton
            )
            it.put(
                createKey(
                    R.id.button_turn_off,
                    KEYCODE_DPAD_LEFT
                ),
                this::doNothing
            )
            it.put(
                createKey(
                    R.id.button_turn_off,
                    KEYCODE_DPAD_RIGHT
                ),
                this::doNothing
            )
            it.put(
                createKey(
                    R.id.button_turn_on,
                    KEYCODE_DPAD_LEFT
                ),
                this::doNothing
            )
            it.put(
                createKey(
                    R.id.button_turn_on,
                    KEYCODE_DPAD_RIGHT
                ),
                this::doNothing
            )
        }
    }

    private fun consumeDownKeyOnTitle(currentFocus: View): Boolean {
        currentFocus.rootView.findViewById<RecyclerView>(R.id.gridRV)?.sendFocusToFirstElement()
        return true
    }

    private fun consumeDownKeyOnTurnOnButton(currentFocus: View): Boolean {
        currentFocus.nextFocusDownId = R.id.button_turn_off
        return false
    }

    private fun consumeUpKeyOnTurnOnButton(currentFocus: View): Boolean {
        currentFocus.nextFocusUpId = R.id.carousel_container
        return false
    }

    private fun consumeUpKeyOnTurnOffButton(currentFocus: View): Boolean {
        currentFocus.nextFocusUpId = R.id.button_turn_on
        return false
    }

    @Suppress("UNUSED_PARAMETER")
    private fun doNothing(currentFocus: View): Boolean {
        return true
    }
}