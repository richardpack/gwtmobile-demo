/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ui.gwt.mobile.client.components.mobile;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.EventTarget;

public class Touch extends JavaScriptObject {

    protected Touch() {
    }

    public final native int getClientX() /*-{
        return this.clientX;
    }-*/;

    public final native int getClientY() /*-{
        return this.clientY;
    }-*/;

    public final native int screenX() /*-{
        return this.screenX;
    }-*/;

    public final native int screenY() /*-{
        return this.screenY;
    }-*/;

    public final native double getPageX() /*-{
        return this.pageX;
    }-*/;

    public final native double getPageY() /*-{
        return this.pageY;
    }-*/;

    public final native EventTarget getTarget() /*-{
        return this.target;
    }-*/;
}
