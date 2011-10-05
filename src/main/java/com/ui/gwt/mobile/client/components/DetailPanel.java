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
import com.google.gwt.dom.client.Element;
import com.google.gwt.maps.client.InfoWindow;
import com.google.gwt.maps.client.InfoWindowContent;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.geocode.Geocoder;
import com.google.gwt.maps.client.geocode.LatLngCallback;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.ui.gwt.mobile.client.model.Contact;
import com.ui.gwt.mobile.client.resources.AppResources;
import com.ui.gwt.mobile.client.resources.Messages;

/**
 * DetailPanel Component - Renders a Contact detail
 *
 * @author rpack
 * @since 1.0
 */
public class DetailPanel extends SimplePanel {

    private final Element detail;
    private final Element map;
    private MapWidget mapWidget;
    private Geocoder geocoder;

    public interface Template extends SafeHtmlTemplates {
        @Template("<div class='{0}'>" +
                "    <img alt='{1}' class='{2}' src='{3}'/>" +
                "    <div class='{4}'>" +
                "        <h6>{5}</h6>" +
                "        {6}" +
                "    </div>" +
                "</div>")
        public SafeHtml detail(String containerClass, String imageAlt, String imgClass, String imgURL, String detailBlockClass, String name, SafeHtml contents);

        @Template("<div>{0}</div>")
        public SafeHtml item(String data);

        @Template("<a href='{0}' target='new'>{1}</a><br/>")
        public SafeHtml activeItem(String url, String data);

        @Template("<br/>")
        public SafeHtml spacer();

        @Template("<div class='{0}'>{1}</div>")
        public SafeHtml empty(String emptyClass, String emptyMessage);

    }

    private static final Template TEMPLATE = GWT.create(Template.class);

    public DetailPanel() {
        Element container = getElement();
        detail = DOM.createDiv();

        map = DOM.createDiv();
        map.setId("map");
        container.appendChild(detail);
        container.appendChild(map);
        setStyleName(AppResources.INSTANCE.css().detailPanel());
        detail.setInnerHTML(TEMPLATE.empty(AppResources.INSTANCE.css().empty(), Messages.INSTANCE.detailEmpty()).asString());
    }

    public void setData(Contact data) {
        SafeHtmlBuilder builder = new SafeHtmlBuilder();
        builder.append(TEMPLATE.activeItem("tel:" + data.getPhone(), data.getPhone()));
        builder.append(TEMPLATE.activeItem("mailto:" + data.getEmail(), data.getEmail()));
        builder.append(TEMPLATE.activeItem(data.getWebAddr(), data.getWebAddr()));
        builder.append(TEMPLATE.spacer());
        builder.append(TEMPLATE.item(data.getAddr1()));
        builder.append(TEMPLATE.item(data.getAddr2()));
        String template = TEMPLATE.detail(AppResources.INSTANCE.css().details(),
                "", AppResources.INSTANCE.css().profilePic(), data.getPicURL(), AppResources.INSTANCE.css().detailBlock(), data.getName(), builder.toSafeHtml()).asString();

        detail.setInnerHTML(template);
//        buildMap(data);
    }

    public void buildMap(Contact data) {
        if (mapWidget == null) {
            map.addClassName(AppResources.INSTANCE.css().map());
            mapWidget = new MapWidget();
            mapWidget.setWidth("100%");
            mapWidget.setHeight("400px");
            geocoder = new Geocoder();
            add(mapWidget);
        }
        final InfoWindow info = mapWidget.getInfoWindow();
        final String address = data.getAddr1() + " " + data.getAddr2();
        geocoder.getLatLng(address, new LatLngCallback() {
            @Override
            public void onFailure() {
            }

            @Override
            public void onSuccess(LatLng point) {
                mapWidget.setCenter(point, 13);
                Marker marker = new Marker(point);
                mapWidget.clearOverlays();
                mapWidget.addOverlay(marker);
                info.open(marker, new InfoWindowContent(address));
            }
        });
    }

    @Override
    public void setWidget(Widget w) {
        // Validate
        if (w == getWidget()) {
            return;
        }

        // Detach new child.
        if (w != null) {
            w.removeFromParent();
        }

        // Remove old child.
        if (getWidget() != null) {
            remove(getWidget());
        }

        if (w != null) {
            // Physical attach.
            DOM.appendChild((com.google.gwt.user.client.Element) map, w.getElement());
            adopt(w);
        }
    }

}
