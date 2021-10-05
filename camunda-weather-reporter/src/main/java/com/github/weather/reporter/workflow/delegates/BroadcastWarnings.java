package com.github.weather.reporter.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class BroadcastWarnings implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("*************** BROADCAST WARNINGS: **************** " +
                execution.getVariable("warnings"));
    }
}
