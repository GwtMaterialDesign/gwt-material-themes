/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.themes.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple asynchronous loader for our preset themes.
 * @author Ben Dol
 */
public class ThemeLoader {

    public interface ThemeAsyncCallback {
        /**
         * Called once the necessary code for it has been loaded.
         * @param resourceCount The total number of resources loaded.
         */
        void onSuccess(int resourceCount);

        /**
         * Called when, for some reason, the necessary code cannot be loaded. For
         * example, the web browser might no longer have network access.
         */
        void onFailure(Throwable reason);
    }

    public interface ThemeBundle extends ClientBundle {
        TextResource style();
        TextResource overrides();
    }

    private static List<Element> elements;

    /**
     * Load a provided {@link ThemeBundle} asynchronously.
     *
     * @param bundle The required theme bundle.
     * @param callback The async callback.
     */
    public static void loadAsync(final ThemeBundle bundle, final ThemeAsyncCallback callback) {
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onSuccess() {
                if(bundle != null) {
                    if(elements == null) {
                        elements = new ArrayList<>();
                    } else {
                        unload();
                    }

                    // More resources might be loaded in the future.
                    elements.add(StyleInjector.injectStylesheet(bundle.style().getText()));
                    elements.add(StyleInjector.injectStylesheet(bundle.overrides().getText()));
                }

                if(callback != null) {
                    callback.onSuccess(elements.size());
                }
            }
            @Override
            public void onFailure(Throwable reason) {
                if(callback != null) {
                    callback.onFailure(reason);
                }
            }
        });
    }

    /**
     * Unload the current loaded theme.
     */
    public static void unload() {
        if(elements != null) {
            for (Element style : elements) {
                style.removeFromParent();
            }
            elements.clear();
        }
    }
}
