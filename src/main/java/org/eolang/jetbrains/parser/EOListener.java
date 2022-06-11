package org.eolang.jetbrains.parser;// Generated from /Users/stepan/huawei/EO-intellij-plugin/src/main/antlr/org/jetbrains/eolang/parser/EO.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EOParser}.
 */
public interface EOListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EOParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(EOParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(EOParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#license}.
	 * @param ctx the parse tree
	 */
	void enterLicense(EOParser.LicenseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#license}.
	 * @param ctx the parse tree
	 */
	void exitLicense(EOParser.LicenseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#metas}.
	 * @param ctx the parse tree
	 */
	void enterMetas(EOParser.MetasContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#metas}.
	 * @param ctx the parse tree
	 */
	void exitMetas(EOParser.MetasContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#objects}.
	 * @param ctx the parse tree
	 */
	void enterObjects(EOParser.ObjectsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#objects}.
	 * @param ctx the parse tree
	 */
	void exitObjects(EOParser.ObjectsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(EOParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(EOParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#abstraction}.
	 * @param ctx the parse tree
	 */
	void enterAbstraction(EOParser.AbstractionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#abstraction}.
	 * @param ctx the parse tree
	 */
	void exitAbstraction(EOParser.AbstractionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterAttributes(EOParser.AttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitAttributes(EOParser.AttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(EOParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(EOParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(EOParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(EOParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#tail}.
	 * @param ctx the parse tree
	 */
	void enterTail(EOParser.TailContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#tail}.
	 * @param ctx the parse tree
	 */
	void exitTail(EOParser.TailContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#suffix}.
	 * @param ctx the parse tree
	 */
	void enterSuffix(EOParser.SuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#suffix}.
	 * @param ctx the parse tree
	 */
	void exitSuffix(EOParser.SuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(EOParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(EOParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#application}.
	 * @param ctx the parse tree
	 */
	void enterApplication(EOParser.ApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#application}.
	 * @param ctx the parse tree
	 */
	void exitApplication(EOParser.ApplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#htail}.
	 * @param ctx the parse tree
	 */
	void enterHtail(EOParser.HtailContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#htail}.
	 * @param ctx the parse tree
	 */
	void exitHtail(EOParser.HtailContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#head}.
	 * @param ctx the parse tree
	 */
	void enterHead(EOParser.HeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#head}.
	 * @param ctx the parse tree
	 */
	void exitHead(EOParser.HeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#has}.
	 * @param ctx the parse tree
	 */
	void enterHas(EOParser.HasContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#has}.
	 * @param ctx the parse tree
	 */
	void exitHas(EOParser.HasContext ctx);
	/**
	 * Enter a parse tree produced by {@link EOParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(EOParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link EOParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(EOParser.DataContext ctx);
}