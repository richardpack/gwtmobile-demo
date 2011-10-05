/*
 * Copyright 2011 Richard Pack
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.ui.gwt.mobile.client.utils;

import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author rpack
 * @since 1.0
 */
public final class EventUtils {

    /**
     * Utility Class
     */
    private EventUtils() {
    }

    public static void sinkClickEvent(Widget widget) {
        if (BrowserUtils.isMobile) {
            widget.sinkEvents(Event.ONTOUCHEND);
        } else {
            widget.sinkEvents(Event.ONCLICK);
        }
    }

}
