package com.example.demo.listener;

import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestExecutionResult;

public class TestResultListener implements TestExecutionListener {

    @Override
    public void executionFinished(TestIdentifier testIdentifier,
                                  TestExecutionResult testExecutionResult) {

        if (testIdentifier.isTest()) {
            switch (testExecutionResult.getStatus()) {
                case SUCCESSFUL:
                    System.out.println("TEST PASSED");
                    break;
                case FAILED:
                    System.out.println("TEST FAILED");
                    break;
                case ABORTED:
                    System.out.println("TEST ABORTED");
                    break;
            }
        }
    }
}
