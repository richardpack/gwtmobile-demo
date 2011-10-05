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

package com.ui.gwt.mobile.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.ui.gwt.mobile.client.components.ContactListPanel;
import com.ui.gwt.mobile.client.components.DetailPanel;
import com.ui.gwt.mobile.client.components.Heading;
import com.ui.gwt.mobile.client.components.MobileScrollPanel;
import com.ui.gwt.mobile.client.model.Contact;
import com.ui.gwt.mobile.client.resources.AppResources;
import com.ui.gwt.performance.client.PerfConfig;
import com.ui.gwt.performance.client.PerfTimer;

import java.util.ArrayList;

public class MobileEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        //Remove the address bar (IOS & homescreen bookmark only)
        Window.scrollTo(0, 1);
        //Inject the stylesheet into the head tag
        AppResources.INSTANCE.css().ensureInjected();

        //Enable performance logging for the app
        PerfConfig.setEnableAllClasses(true);
        PerfConfig.setPerfEnabled(true);
        PerfConfig.setLogImmediately(true);

        PerfTimer timer = PerfTimer.get(this, "init");

        //create a 2 column layout
        DockLayoutPanel dockPanel = new DockLayoutPanel(Style.Unit.PCT);
        dockPanel.setStyleName(AppResources.INSTANCE.css().container());

        MobileScrollPanel scrollPanel = new MobileScrollPanel(true);
        final ContactListPanel listPanel = new ContactListPanel();
        scrollPanel.add(listPanel);
        FlowPanel west = new FlowPanel();
        west.add(new Heading("Contacts"));
        west.add(scrollPanel);
        dockPanel.addWest(west, 30); //30%

        final DetailPanel detail = new DetailPanel();
        FlowPanel east = new FlowPanel();
        east.add(new Heading("Contact Details"));
        east.add(detail);
        dockPanel.addEast(east, 70); //70%

        listPanel.addSelectionHandler(new SelectionHandler<Contact>() {
            @Override
            public void onSelection(SelectionEvent<Contact> contactSelectionEvent) {
                detail.setData(contactSelectionEvent.getSelectedItem());
            }
        });

        MobileRPCService.App.getInstance().getContacts(new AsyncCallback<ArrayList<Contact>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Having trouble communicating with the server.");
            }

            @Override
            public void onSuccess(ArrayList<Contact> result) {
                listPanel.setData(result);
            }
        });

        //remove loading indicator
        RootPanel.get("loading").getElement().setInnerHTML("");

        RootLayoutPanel.get().add(dockPanel);
        timer.end();
    }

}
