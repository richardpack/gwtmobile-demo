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

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.Widget;
import com.ui.gwt.mobile.client.model.Contact;
import com.ui.gwt.mobile.client.resources.AppResources;
import com.ui.gwt.mobile.client.resources.Messages;
import com.ui.gwt.mobile.client.utils.EventUtils;
import com.ui.gwt.performance.client.PerfTimer;

import java.util.ArrayList;

/**
 * @author rpack
 * @since 1.0
 */
public class ContactListPanel extends Widget implements HasSelectionHandlers<Contact>, EventListener {

    private ArrayList<Contact> data;
    private int selected = 0;

    public interface Template extends SafeHtmlTemplates {
        @Template("<li>" +
                "    <img alt='{0}' class='{1}' src='{2}'/>" +
                "    <div class='{3}'>" +
                "        <h6>{4}</h6>" +
                "        <div>{5}</div>" +
                "        <div>{6}</div>" +
                "    </div><div class='listChevron'><span></span><span></span></div>" +
                "</li>")
        public SafeHtml item(String imageAlt, String imgClass, String imgURL,
                             String detailBlockClass, String name, String email, String phone);

        @Template("<li class='{0}'><img src='{1}'/>{2}</li>")
        public SafeHtml loading(String className, String img, String message);
    }

    private static final Template TEMPLATE = GWT.create(Template.class);

    public ContactListPanel() {
        setElement(Document.get().createOLElement());
        setStyleName(AppResources.INSTANCE.css().contactList());
        EventUtils.sinkClickEvent(this);
        render();
    }

    public void setData(ArrayList<Contact> contacts) {
        this.data = contacts;
        render();
    }

    private void render() {
        PerfTimer timer = PerfTimer.get(this, "render");
        SafeHtmlBuilder builder = new SafeHtmlBuilder();
        if (data != null) {
            for (Contact c : data) {
                builder.append(TEMPLATE.item("", AppResources.INSTANCE.css().profilePic(), c.getPicURL(),
                        AppResources.INSTANCE.css().detailBlock(), c.getName(), c.getEmail(), c.getPhone()));
            }
        } else {
            builder.append(TEMPLATE.loading(AppResources.INSTANCE.css().loading(),
                    AppResources.INSTANCE.loadingImage().getURL(), Messages.INSTANCE.listLoading()));
        }
        getElement().setInnerHTML(builder.toSafeHtml().asString());
        timer.end();
    }

    @Override
    public HandlerRegistration addSelectionHandler(SelectionHandler<Contact> contactSelectionHandler) {
        return addHandler(contactSelectionHandler, SelectionEvent.getType());
    }

    @Override
    public void onBrowserEvent(Event event) {
        PerfTimer timer = PerfTimer.get(this, "onBrowserEvent");
        Element target = Element.as(event.getEventTarget());
        int index = getTargetItemIndex(target);
        if (index != -1) {
            //Don't need to support de-select since there is no gesture modifier
            Element.as(getElement().getChildNodes().getItem(selected)).removeClassName(AppResources.INSTANCE.css().selected());
            Element.as(getElement().getChildNodes().getItem(index)).addClassName(AppResources.INSTANCE.css().selected());
            SelectionEvent.fire(this, data.get(index));
            this.selected = index;
        }
        timer.end();
    }

    private int getTargetItemIndex(Element target) {
        assert !target.equals(this.getElement()); //The markup is now broken

        while (!target.getParentElement().equals(this.getElement())) {
            target = target.getParentElement();
        }
        return DOM.getChildIndex(this.getElement(), (com.google.gwt.user.client.Element) target);
    }
}
