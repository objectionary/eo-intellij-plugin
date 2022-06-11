package org.eolang.jetbrains.parser;// Generated from /Users/stepan/huawei/EO-intellij-plugin/src/main/antlr/org/jetbrains/eolang/parser/EO.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EOParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EOVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EOParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(EOParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#license}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLicense(EOParser.LicenseContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#metas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetas(EOParser.MetasContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#objects}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjects(EOParser.ObjectsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(EOParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#abstraction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstraction(EOParser.AbstractionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributes(EOParser.AttributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(EOParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(EOParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTail(EOParser.TailContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#suffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffix(EOParser.SuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(EOParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#application}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplication(EOParser.ApplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#htail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtail(EOParser.HtailContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHead(EOParser.HeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#has}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHas(EOParser.HasContext ctx);
	/**
	 * Visit a parse tree produced by {@link EOParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData(EOParser.DataContext ctx);
}