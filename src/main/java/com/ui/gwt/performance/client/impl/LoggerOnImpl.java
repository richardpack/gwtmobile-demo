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

package com.ui.gwt.performance.client.impl;

import com.google.gwt.core.client.GWT;
import com.ui.gwt.performance.client.Logger;

/**
 * @author rpack
 * @since 1.0
 */
public class LoggerOnImpl implements Logger {

    @Override
    public void log(String message) {
        consoleInfo(message);
        GWT.log(message);
    }

    @Override
    public void perf(String message) {
        log(message);
    }

    private static native void consoleInfo(String message) /*-{
        var log = $doc.getElementById('log');
        if (log) {
            log.innerHTML = log.innerHTML + '<br/>' + msg;
        }
        else {
            if ($wnd.console && $wnd.console.log) {
                $wnd.console.log(message);
            }
        }
    }-*/;
}
