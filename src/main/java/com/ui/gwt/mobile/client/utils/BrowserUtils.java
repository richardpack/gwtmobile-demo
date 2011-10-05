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

import com.google.gwt.user.client.Window;

/**
 * @author rpack
 * @since 1.0
 */
public final class BrowserUtils {

    public static boolean isMobile;

    public static boolean isAndroid;

    public static boolean isIOS;

    static {
        String ua = Window.Navigator.getUserAgent().toLowerCase();

        if (ua.contains("android")) {
            isAndroid = true;
            isMobile = true;
        }

        if (ua.contains("ipad") || ua.contains("iphone")) {
            isIOS = true;
            isMobile = true;
        }
    }

    /**
     * Utility Class
     */
    private BrowserUtils() {
    }
}
