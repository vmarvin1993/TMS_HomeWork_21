package service;

import entity.Operation;
import entity.User;
import storage.OperationStorage;
import java.util.*;

public class CalcService {

    OperationStorage operationStorage = new OperationStorage();

    public Operation calculate(double a, double b, String op, User user) {
        switch (op) {
            case "sum":
                Operation sum = new Operation(a, b, op, a + b, user);
                operationStorage.save(sum);
                return sum;
            case "sub":
                Operation sub = new Operation(a, b, op, a - b, user);
                operationStorage.save(sub);
                return sub;
            case "mult":
                Operation mult = new Operation(a, b, op, a * b, user);
                operationStorage.save(mult);
                return mult;
            case "del":
                Operation del = new Operation(a, b, op, a / b, user);
                operationStorage.save(del);
                return del;
        }
        return null;
    }

    public List<Operation> findAllUser(User user) {
        List<Operation> operationList = new ArrayList<>();
        for (Operation operation : operationStorage.getAll()) {
            if (operation.getUser().getUsername().equals(user.getUsername())) {
                operationList.add(operation);
            }

        }
        return operationList;
    }
}
