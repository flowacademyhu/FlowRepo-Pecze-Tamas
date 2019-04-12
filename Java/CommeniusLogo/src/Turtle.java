public class Turtle {
    private int positionA; // up-down
    private int positionB; // left-right
    private boolean tollStatus;
    private int sizeA;
    private int sizeB;

    public Turtle() {

    }

    public Turtle(int sizeA, int sizeB) {
        this.positionA = 0;
        this.positionB = 0;
        this.tollStatus = false;
        this.sizeA = sizeA;
        this.sizeB = sizeB;
    }

    public void changePen(boolean pen) {
        tollStatus = pen;
    }

    @Override
    public String toString() {
        return "The turtle is in A:" + positionA + " B:" + positionB + " Status = " + tollStatus +
                " Map size A:=" + sizeA + " Map size B: =" + sizeB;
    }

//    public boolean move (String direction) {
//        if(direction.equals("up") && positionA < sizeA) {
//            positionA++;
//            return true;
//        } else if(direction.equals("down") && positionA > 0) {
//            positionA--;
//            return true;
//        } else if(direction == "left" && positionB > 0) {
//            positionB--;
//        } else if(direction == "right" && positionA < sizeB) {
//            positionB++;
//        } else {
//            return false;
//        }
//        return false;
//    }
        public void move (String direction) {
            if(direction.equals("up")) {
                if(positionA > 0) {
                    positionA--;
                }
            } else if(direction.equals("down")) {
                if(positionA < sizeA -1) {
                    positionA++;
                }
            } else if(direction.equals("right")) {
                if(positionB < sizeB - 1) {
                    positionB++;
                }
            } else if(direction.equals("left")) {
                if(positionB > 0) {
                    positionB--;
                }
            }
        }

    public int getPositionA() {
        return positionA;
    }

    public void setPositionA(int positionA) {
        this.positionA = positionA;
    }

    public int getPositionB() {
        return positionB;
    }

    public void setPositionB(int positionB) {
        this.positionB = positionB;
    }

    public boolean isTollStatus() {
        return tollStatus;
    }

    public void setTollStatus(boolean tollStatus) {
        this.tollStatus = tollStatus;
    }

    public int getSizeA() {
        return sizeA;
    }

    public void setSizeA(int sizeA) {
        this.sizeA = sizeA;
    }

    public int getSizeB() {
        return sizeB;
    }

    public void setSizeB(int sizeB) {
        this.sizeB = sizeB;
    }
}
