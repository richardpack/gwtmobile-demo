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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.ui.gwt.mobile.client.resources.AppResources;


/**
 * @author rpack
 * @since 1.0
 */
public class Heading extends Widget {
    public Heading(String text) {
        Element e = Document.get().createHElement(1);
        setElement(e);
        e.setClassName(AppResources.INSTANCE.css().heading());
        e.setInnerText(text);
    }
}
