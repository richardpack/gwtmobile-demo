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

package com.ui.gwt.mobile.client.components;

import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.ui.gwt.mobile.client.components.mobile.Scroller;
import com.ui.gwt.mobile.client.resources.AppResources;
import com.ui.gwt.mobile.client.utils.BrowserUtils;

/**
 * @author rpack
 * @since 1.0
 */
public class MobileScrollPanel extends SimplePanel {

    private final SimplePanel container;

    public MobileScrollPanel(boolean forceMobileBehavior) {
        container = new SimplePanel();
        add(container);
        if (forceMobileBehavior || BrowserUtils.isIOS || BrowserUtils.isAndroid) {
            getElement().setClassName(AppResources.INSTANCE.css().scrollerFrameMobile());
            Scroller scroller = new Scroller(getElement(), container.getElement(), true);
            scroller.setMomentum(true);
        } else {
            getElement().setClassName(AppResources.INSTANCE.css().scrollerFrameDesktop());
        }
    }

    @Override
    public void add(Widget w) {
        if (w instanceof SimplePanel) {
            super.add(w);
        } else {
            container.add(w);
        }
    }

}
