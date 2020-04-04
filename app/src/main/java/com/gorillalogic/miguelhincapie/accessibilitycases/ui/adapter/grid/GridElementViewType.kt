package com.gorillalogic.miguelhincapie.accessibilitycases.ui.adapter.grid

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
import com.gorillalogic.miguelhincapie.accessibilitycases.ui.adapter.RecyclerViewType
import com.gorillalogic.miguelhincapie.domain.entities.GridElement

class GridElementViewType(val gridElement: GridElement) :
    RecyclerViewType {

    override fun getViewTypeId() = gridElement.id
    override fun getViewType() = ITEM.hashCode()

    companion object {
        const val ITEM = "GridElementViewType"
    }
}