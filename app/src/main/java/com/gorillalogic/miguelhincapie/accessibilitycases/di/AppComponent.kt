package com.gorillalogic.miguelhincapie.accessibilitycases.di

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
import android.content.Context
import com.gorillalogic.miguelhincapie.accessibilitycases.ui.di.ActivityBuilderModule
import com.gorillalogic.miguelhincapie.domain.di.DomainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import java.lang.ref.WeakReference

@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, DomainModule::class])
interface AppComponent : AndroidInjector<AccessibilityApplication> {
    @Component.Factory
    interface Factory {
        fun build(@BindsInstance contextWR: WeakReference<Context>): AppComponent
    }

//    fun getContext(): Context
}