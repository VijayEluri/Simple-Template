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

package com.jaliansystems.simpletemplate.internal.reader;

import java.io.PrintStream;

import com.jaliansystems.simpletemplate.EvaluationMode;
import com.jaliansystems.simpletemplate.internal.templates.EvaluationError;

public class Log {

	private static EvaluationMode mode = EvaluationMode.RELAXED;

	private static PrintStream writer = System.err;

	public static void warning(String fileName, int lineNumber, String message) {
		if (mode == EvaluationMode.STRICT)
			throw new EvaluationError(fileName + ":" + lineNumber + ": error " + message);
		else
			writer.println(fileName + ":" + lineNumber + ": warning " + message);
	}

	public static void setMode(EvaluationMode mode) {
		Log.mode = mode;
	}

}
