package com.gorillalogic.miguelhincapie.accessibilitycases.accessibility.delegate

import android.view.KeyEvent.*
import android.view.View
import com.gorillalogic.miguelhincapie.accessibilitycases.R
import com.gorillalogic.miguelhincapie.accessibilitycases.accessibility.BaseKeyEventDelegate
import com.gorillalogic.miguelhincapie.accessibilitycases.accessibility.createKey

class GridKeyEventDelegate : BaseKeyEventDelegate() {

    init {
        keyEventActionMap.let {
            it.put(
                createKey(R.id.grid_element_item, KEYCODE_DPAD_DOWN, ACTION_DOWN),
                this::onDownKeyPressed
            )
            it.put(
                createKey(R.id.grid_element_item, KEYCODE_DPAD_UP, ACTION_DOWN),
                this::onUpKeyPressed
            )
        }
    }

    private fun onDownKeyPressed(currentFocus: View): Boolean {
        return false
    }

    private fun onUpKeyPressed(currentFocus: View): Boolean {
        return false
    }
}