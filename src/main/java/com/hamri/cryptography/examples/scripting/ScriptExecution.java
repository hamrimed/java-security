package com.hamri.cryptography.examples.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Date;

public class ScriptExecution {
    private String scriptText;
    private Date creationTime;
    private Date executionTime;
    private ScriptExecutionResult  executionResult;
    private ScriptEngine scriptEngine;

    public Object execute() {
        try {
            return  scriptEngine.eval(scriptText);
        } catch (ScriptException e) {
            return e;
        }
    }

    public ScriptExecution(ScriptEngine scriptEngine) {
        this.scriptEngine = scriptEngine;
        creationTime = new Date();
    }

    public ScriptExecution(ScriptEngine scriptEngine, String scriptText) {
        this(scriptEngine);
        this.scriptText = scriptText;
    }

    public ScriptExecution(ScriptEngine scriptEngine, String scriptText, ScriptExecutionResult executionResult) {
        this(scriptEngine, scriptText);
        this.executionResult = executionResult;
    }

    public String getScriptText() {
        return scriptText;
    }

    public void setScriptText(String scriptText) {
        this.scriptText = scriptText;
    }

    public ScriptExecutionResult getExecutionResult() {
        return executionResult;
    }

    public void setExecutionResult(ScriptExecutionResult executionResult) {
        if (this.executionResult == null) {
            this.executionResult = executionResult;
            this.executionTime = new Date();
        }
        else {
            throw new UnsupportedOperationException("ScriptExecutionResult already initialized");
        }
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }
}
