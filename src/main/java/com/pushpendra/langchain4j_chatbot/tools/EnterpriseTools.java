package com.pushpendra.langchain4j_chatbot.tools;

import dev.langchain4j.agent.tool.Tool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class EnterpriseTools {

    @Tool("Get current date and time")
    public String getCurrentTime() {

        LocalDateTime now = LocalDateTime.now();

        return now.format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    @Tool("Get employee details using employee ID")
    public String getEmployeeDetails(String employeeId) {

        Map<String, String> employees = new HashMap<>();

        employees.put(
                "EMP001",
                "Rahul Sharma | Engineering | Experience: 5 Years");

        employees.put(
                "EMP002",
                "Priya Singh | Human Resources | Experience: 3 Years");

        employees.put(
                "EMP003",
                "Amit Verma | Finance | Experience: 7 Years");

        return employees.getOrDefault(
                employeeId.toUpperCase(),
                "Employee not found");
    }

    @Tool("Get product details using product code")
    public String getProductDetails(String productId) {

        Map<String, String> products = new HashMap<>();

        products.put(
                "P100",
                "MacBook Pro | Price: ₹1,80,000");

        products.put(
                "P101",
                "iPhone 16 | Price: ₹85,000");

        products.put(
                "P102",
                "Samsung Galaxy S25 | Price: ₹75,000");

        return products.getOrDefault(
                productId.toUpperCase(),
                "Product not found");
    }

    @Tool("Get employee leave balance")
    public String getLeaveBalance(String employeeId) {

        Map<String, Integer> leaveData = new HashMap<>();

        leaveData.put("EMP001", 12);
        leaveData.put("EMP002", 8);
        leaveData.put("EMP003", 15);

        Integer leaves =
                leaveData.get(employeeId.toUpperCase());

        if (leaves == null) {
            return "Employee not found";
        }

        return "Available leave balance: "
                + leaves
                + " days";
    }

    @Tool("Get React interview question based on level")
    public String getReactInterviewQuestion(String level) {

        if ("beginner".equalsIgnoreCase(level)) {
            return "What is Virtual DOM in React?";
        }

        if ("intermediate".equalsIgnoreCase(level)) {
            return "Explain useMemo vs useCallback.";
        }

        if ("advanced".equalsIgnoreCase(level)) {
            return "Explain React Fiber Architecture.";
        }

        return "Supported levels: beginner, intermediate, advanced";
    }
}