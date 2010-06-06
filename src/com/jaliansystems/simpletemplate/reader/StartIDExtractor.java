package com.jaliansystems.simpletemplate.reader;

import java.io.IOException;

import com.jaliansystems.simpletemplate.templates.LoopTemplate;
import com.jaliansystems.simpletemplate.templates.TemplateElement;

public final class StartIDExtractor implements ITemplateExtractor {

	@Override
	public TemplateElement extract(Token t, ILexer lexer) throws IOException,
			LexerException, ParserException {
		return createStartIdTemplate(t, lexer);
	}

	private TemplateElement createStartIdTemplate(Token t, ILexer lexer)
			throws IOException, LexerException, ParserException {
		TemplateElement ite;
		if (isSimpleName(t)) {
			Token token = lexer.expect1r0(TokenType.TT_OPEN_PAREN);
			if (token != null)
				return new SubtemplateExtractor().extract(t, lexer);
		}
		TemplateElement vt = new ExpressionExtractor().extract(t, lexer);
		Token nextToken = lexer.expect1(TokenType.getExtractableTokens(),
				TokenType.TT_END_TEMPLATE);
		if (nextToken.getType() == TokenType.TT_END_TEMPLATE) {
			ite = vt;
		} else if (nextToken.getType() == TokenType.TT_METHOD_CALL) {
			MethodCallTemplate mct = (MethodCallTemplate) nextToken.extract();
			mct.setVariable(vt);
			ite = mct ;
		} else {
			TemplateElement template = nextToken.extract();
			ite = new LoopTemplate(vt, template, t.getFileName(),
					t.getLineNumber());
		}
		return ite;
	}

	private boolean isSimpleName(Token t) {
		return !t.getValue().contains(".");
	}

}