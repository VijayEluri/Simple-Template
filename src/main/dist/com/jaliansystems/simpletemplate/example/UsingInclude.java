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

import java.io.IOException;

import com.jaliansystems.simpletemplate.TemplateReader;
import com.jaliansystems.simpletemplate.Scope;
import com.jaliansystems.simpletemplate.templates.TemplateElement;

public class UsingInclude {

	public static void main(String[] args) {
		try {
			printUsingInclude();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printUsingInclude() throws Exception, IOException {
		TemplateReader reader = TemplateReader
				.fromFile("template.st");
		Scope scope = new Scope();
		AddressBook book = AddressBook.populate();
		scope.put("addressBook", book);
		TemplateElement template = reader.readTemplate();
		String result = template.apply(scope);
		System.out.println("Result " + result);
	}

}
