/**
 * Copyright 2012-2013 Wicked Charts (http://wicked-charts.googlecode.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.wickedcharts.highcharts.options.theme;

import java.io.Serializable;

/**
 * Defined options for the states of a theme.
 * 
 * @author Jean-Philippe Signorino
 * 
 */
public class States implements Serializable {

	private static final long serialVersionUID = 1L;

	private State hover;

	private State select;

	public State getHover() {
		return hover;
	}
	
	public States setHover(State hover) {
		this.hover = hover;
		return this;
	}
	
	public State getSelect() {
		return select;
	}
	
	public States setSelect(State select) {
		this.select = select;
		return this;
	}
	
}
