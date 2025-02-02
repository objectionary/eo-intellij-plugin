package org.eolang.jetbrains;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса {@link EoCommenter}.
 * @since 0.0.5
 */
class EoCommenterTest {

    /**
     * Проверяет, что префикс для однострочного комментария возвращается корректно.
     */
    @Test
    void testLineCommentPrefix() {
        final EoCommenter commenter = new EoCommenter();
        assertEquals("#", commenter.getLineCommentPrefix(), "Префикс однострочного комментария должен быть '#'");
    }

    /**
     * Проверяет, что префикс для блочного комментария возвращается корректно.
     */
    @Test
    void testBlockCommentPrefix() {
        final EoCommenter commenter = new EoCommenter();
        assertEquals("", commenter.getBlockCommentPrefix(), "Префикс блочного комментария должен быть пустой строкой");
    }

    /**
     * Проверяет, что суффикс для блочного комментария возвращается корректно.
     */
    @Test
    void testBlockCommentSuffix() {
        final EoCommenter commenter = new EoCommenter();
        assertNull(commenter.getBlockCommentSuffix(), "Суффикс блочного комментария должен быть null");
    }

    /**
     * Проверяет, что префикс для закомментированного блочного комментария возвращается корректно.
     */
    @Test
    void testCommentedBlockCommentPrefix() {
        final EoCommenter commenter = new EoCommenter();
        assertEquals("", commenter.getCommentedBlockCommentPrefix(), "Префикс закомментированного блочного комментария должен быть пустой строкой");
    }

    /**
     * Проверяет, что суффикс для закомментированного блочного комментария возвращается корректно.
     */
    @Test
    void testCommentedBlockCommentSuffix() {
        final EoCommenter commenter = new EoCommenter();
        assertNull(commenter.getCommentedBlockCommentSuffix(), "Суффикс закомментированного блочного комментария должен быть null");
    }
}