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

import java.io.IOException;

public interface ILexer {

	public Token lookAhead() throws IOException, LexerException;

	public void pushbackLACharacters() throws IOException;

	public Token expect1(TokenType... types) throws IOException,
			LexerException, ParserException;

	public Token expect1r0(TokenType... types) throws IOException,
			LexerException, ParserException;

	public Token expect1(TokenType[] types, TokenType... others) throws IOException,
			LexerException, ParserException;

	public Token expect1r0(TokenType[] types, TokenType... others) throws IOException,
			LexerException, ParserException;

	public LexerReader getReader();

	public String getStartToken();

	public String getEndToken();
}
