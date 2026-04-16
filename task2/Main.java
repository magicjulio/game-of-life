import model.Tree;


class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();

        test4();
        test5();
        test6();

        test7();
        test8();
        test9();

        System.out.println("Test passed.");
    }

    private static void test1() {
        Tree tree = new Tree(10);
        String result = tree.str(null);
        assertEquals("", result, "empty string");
    }

    private static void test2() {
        Tree tree = new Tree(7);
        String result = tree.str(tree);
        assertEquals("7", result, "sollte 7 sein");
    }

    private static void test3() {
        Tree root = new Tree(5);
        root.set_left(new Tree(3));
        root.set_right(new Tree(8));
        root.get_left().set_left(new Tree(1));
        root.get_left().set_right(new Tree(4));

        String result = root.str(root);
        assertEquals("1 3 4 5 8", result, "in-order traversal ust falsch");
    }

    private static void test4() {
        Tree root = new Tree(42);
        assertTrue(root.contains(42), "sollte true sein.");
    }

    private static void test5() {
        Tree root = new Tree(10);
        root.set_left(new Tree(5));
        root.get_left().set_right(new Tree(7));

        assertTrue(root.contains(7), "sollte true sein.");
    }

    private static void test6() {
        Tree root = new Tree(10);
        root.set_left(new Tree(5));
        root.set_right(new Tree(20));

        assertFalse(root.contains(99), "sollte false sein.");
    }

    private static void test7() {
        Tree root = new Tree(10);
        root.insertValue(15);

        assertTrue(root.contains(15), "insert wrong");
        assertEquals("10 15", root.str(root), "insert wrong");
    }

    private static void test8() {
        Tree root = new Tree(10);
        root.insertValue(3);

        assertTrue(root.contains(3), "insert wrong");
        assertEquals("3 10", root.str(root), "insert wrong");
        
    }

    private static void test9() {
        Tree root = new Tree(10);
        root.insertValue(5);
        root.insertValue(15);
        String beforeDuplicateInsert = root.str(root);

        root.insertValue(5);

        String afterDuplicateInsert = root.str(root);
        assertEquals(beforeDuplicateInsert, afterDuplicateInsert,"duplikat");
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertEquals(String expected, String actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + "Expected: " + expected + " Actual: " + actual);
        }
    }
}


