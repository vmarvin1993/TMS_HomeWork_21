package storage;

import entity.Operation;

import java.util.*;

public class OperationStorage {
    private static List<Operation> operationList = new ArrayList<>();

    public void save(Operation operation) {
        operationList.add(operation);
    }

    public List<Operation> getAll() {
        return new ArrayList<>(operationList);
    }
}
