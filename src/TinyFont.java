import javax.microedition.lcdui.Graphics;

/**
 * Tiny 3x5 bitmap font renderer.
 *
 * Inspired by the TinyFont idea used in:
 * https://github.com/AzizBgBoss/linux-j2me
 */
public final class TinyFont {
    public static final int GLYPH_W = 3;
    public static final int GLYPH_H = 5;
    public static final int CELL_W = 4;
    public static final int CELL_H = 6;

    private TinyFont() {}

    public static void drawChar(Graphics g, char ch, int x, int y) {
        int bits = glyphBits(ch);
        int rowBase = 0;
        for (int row = 0; row < GLYPH_H; row++) {
            int rowBits = (bits >> rowBase) & 0x7;
            if ((rowBits & 0x4) != 0) g.fillRect(x, y + row, 1, 1);
            if ((rowBits & 0x2) != 0) g.fillRect(x + 1, y + row, 1, 1);
            if ((rowBits & 0x1) != 0) g.fillRect(x + 2, y + row, 1, 1);
            rowBase += 3;
        }
    }

    private static int pack(int r0, int r1, int r2, int r3, int r4) {
        return (r0 << 12) | (r1 << 9) | (r2 << 6) | (r3 << 3) | r4;
    }

    private static int glyphBits(char c) {
        switch (c) {
            case 'A': case 'a': return pack(2, 5, 7, 5, 5);
            case 'B': case 'b': return pack(6, 5, 6, 5, 6);
            case 'C': case 'c': return pack(3, 4, 4, 4, 3);
            case 'D': case 'd': return pack(6, 5, 5, 5, 6);
            case 'E': case 'e': return pack(7, 4, 6, 4, 7);
            case 'F': case 'f': return pack(7, 4, 6, 4, 4);
            case 'G': case 'g': return pack(3, 4, 5, 5, 3);
            case 'H': case 'h': return pack(5, 5, 7, 5, 5);
            case 'I': case 'i': return pack(7, 2, 2, 2, 7);
            case 'J': case 'j': return pack(1, 1, 1, 5, 2);
            case 'K': case 'k': return pack(5, 5, 6, 5, 5);
            case 'L': case 'l': return pack(4, 4, 4, 4, 7);
            case 'M': case 'm': return pack(5, 7, 7, 5, 5);
            case 'N': case 'n': return pack(5, 7, 7, 7, 5);
            case 'O': case 'o': return pack(2, 5, 5, 5, 2);
            case 'P': case 'p': return pack(6, 5, 6, 4, 4);
            case 'Q': case 'q': return pack(2, 5, 5, 7, 3);
            case 'R': case 'r': return pack(6, 5, 6, 5, 5);
            case 'S': case 's': return pack(3, 4, 2, 1, 6);
            case 'T': case 't': return pack(7, 2, 2, 2, 2);
            case 'U': case 'u': return pack(5, 5, 5, 5, 7);
            case 'V': case 'v': return pack(5, 5, 5, 5, 2);
            case 'W': case 'w': return pack(5, 5, 7, 7, 5);
            case 'X': case 'x': return pack(5, 5, 2, 5, 5);
            case 'Y': case 'y': return pack(5, 5, 2, 2, 2);
            case 'Z': case 'z': return pack(7, 1, 2, 4, 7);

            case '0': return pack(7, 5, 5, 5, 7);
            case '1': return pack(2, 6, 2, 2, 7);
            case '2': return pack(6, 1, 2, 4, 7);
            case '3': return pack(6, 1, 2, 1, 6);
            case '4': return pack(5, 5, 7, 1, 1);
            case '5': return pack(7, 4, 6, 1, 6);
            case '6': return pack(3, 4, 6, 5, 2);
            case '7': return pack(7, 1, 2, 2, 2);
            case '8': return pack(2, 5, 2, 5, 2);
            case '9': return pack(2, 5, 3, 1, 6);

            case '[': return pack(6, 4, 4, 4, 6);
            case ']': return pack(3, 1, 1, 1, 3);
            case '(': return pack(1, 2, 2, 2, 1);
            case ')': return pack(4, 2, 2, 2, 4);
            case '{': return pack(3, 2, 6, 2, 3);
            case '}': return pack(6, 2, 3, 2, 6);
            case '<': return pack(1, 2, 4, 2, 1);
            case '>': return pack(4, 2, 1, 2, 4);
            case '/': return pack(1, 1, 2, 4, 4);
            case '\\': return pack(4, 4, 2, 1, 1);
            case '-': return pack(0, 0, 7, 0, 0);
            case '_': return pack(0, 0, 0, 0, 7);
            case '=': return pack(0, 7, 0, 7, 0);
            case '+': return pack(0, 2, 7, 2, 0);
            case ':': return pack(0, 2, 0, 2, 0);
            case ';': return pack(0, 2, 0, 2, 4);
            case '.': return pack(0, 0, 0, 0, 2);
            case ',': return pack(0, 0, 0, 2, 4);
            case '\'': return pack(2, 2, 0, 0, 0);
            case '"': return pack(5, 5, 0, 0, 0);
            case '!': return pack(2, 2, 2, 0, 2);
            case '?': return pack(6, 1, 2, 0, 2);
            case '*': return pack(0, 5, 2, 5, 0);
            case '#': return pack(5, 7, 5, 7, 5);
            case '%': return pack(5, 1, 2, 4, 5);
            case '&': return pack(2, 5, 2, 5, 3);
            case '|': return pack(2, 2, 2, 2, 2);
            case '@': return pack(7, 5, 7, 4, 3);
            case '^': return pack(2, 5, 0, 0, 0);
            case '`': return pack(4, 2, 0, 0, 0);
            case '~': return pack(0, 3, 6, 0, 0);
            case '$': return pack(2, 6, 2, 3, 2);
            case ' ': return 0;
            default: return pack(7, 1, 2, 0, 2);
        }
    }
}
