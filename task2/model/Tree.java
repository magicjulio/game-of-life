class Tree {

    public static void main(String[] args) {
        
    }



    int value;
    Tree left;
    Tree right;

    public Tree(int value) {
        this.value = value;
    }

    public void set_value(int val) {
        this.value = val;
    }
    public void set_left(Tree t) {
        this.left = t;
    }

    public void set_right(Tree t) {
        this.right = t;
    }

    public int get_val() {
        return this.value;
    }
    public Tree get_left() {
        return this.left;
    }
    public Tree get_right() {
        return this.right;
    }



    public String str(Tree t) {
        if (t == null) {
            return "";
        }

        String left = str(t.left);
        String right = str(t.right);

        String output = "";
        if (!left.isEmpty()) {
            output += left + " ";
        }
        output += t.value;
        if (!right.isEmpty()) {
            output += " " + right;
        }
        return output;
    }

    public boolean contains(int value) {
        if (this.value == value) {
            return true;
        }

        if (this.left != null && this.left.contains(value)) {
            return true;
        }

        if (this.right != null && this.right.contains(value)) {
            return true;
        }

        return false;
    }

    public void insertValue(int value) {
        if (contains(value)) {
            return;
        }

        if (this.value <  value) {
            if (this.right == null) {
                this.set_right(new Tree(value));
            }
            this.right.insertValue(value);
        }
        else {
            if (this.left == null) {
                this.set_left(new Tree(value));
            }
            this.left.insertValue(value);
        }
    }
}