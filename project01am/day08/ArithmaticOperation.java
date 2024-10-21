public class ArithmaticOperation {

    ArithmaticInterface<Integer> addOps = (a, b) -> {
        return a + b;
    };

    ArithmaticInterface<Integer> multiplyOps = (a, b) -> {
        return a * b;
    };

    ArithmaticInterface<Integer> subtractOps = (a, b) -> {
        return a - b;
    };

    public Integer AddOperation(Integer ta, Integer tb) {
        return this.addOps.process(ta, tb);
    }

    public Integer MultiplyOperation(Integer ta, Integer tb) {
        return this.multiplyOps.process(ta, tb);
    }

    public Integer SubtractOperation(Integer ta, Integer tb) {
        return this.subtractOps.process(ta, tb);
    }

}
