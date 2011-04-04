/*
 * Copyright (c) 2010 Zhihua (Dennis) Jiang
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

package com.gwtmobile.ui.client.widgets;

import com.google.gwt.user.client.ui.HTML;
import com.gwtmobile.ui.client.utils.Utils;


public class CheckBox extends com.google.gwt.user.client.ui.CheckBox {

	public CheckBox() {
		super();
		if (Utils.isAndroid() && Utils.isWVGA()) {
			CheckBoxIndicator indicator = new CheckBoxIndicator();
			this.getElement().insertFirst(indicator.getElement());
		}
	}

	@Override
	public void setValue(Boolean value) {
		setValue(value, false);
	}
	
	@Override
	public void setValue(Boolean checked, boolean fireEvents) {
		super.setValue(checked, fireEvents);
		if (checked) {
			addStyleName("Selected");
		}
		else {
			removeStyleName("Selected");       
		}
	}

	static class CheckBoxIndicator extends HTML {
		
		public CheckBoxIndicator() {
			super("<div><div></div></div><div></div><div></div><div></div>");
			setStyleName("CheckBoxIndicator");
		}
	}
}
