class Block {
    int a, b, c;
    int v;

    Block(int i, int j, int k) {
        a = i;
        b = j;
        c = k;
        v = a * b * c;
    }

    boolean sameBlock(Block ob) {
        return a == ob.a && b == ob.b && c == ob.c;
    }

    boolean sameVolume(Block ob) {
        return ob.v == v;
    }
}