/*
 *   Copyright 2010 Jalian Systems Pvt. Ltd.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.jaliansystems.simpletemplate.example;

import com.jaliansystems.simpletemplate.reader.TemplateReader;
import com.jaliansystems.simpletemplate.templates.Scope;
import com.jaliansystems.simpletemplate.templates.TemplateElement;

public class HelloSimpleTemplate {

	public static void main(String[] args) {
		try {
			TemplateReader reader = TemplateReader.fromString("Hello $greeting$");
			TemplateElement template = reader.readTemplate();
			Scope scope = new Scope();
			scope.put("greeting", "Simple Template");
			String result = template.apply(scope);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
