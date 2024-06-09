package com.hamri.cryptography.examples.scripting;

public class ScriptExecutionResult {
    private String result;
    private String output;
    private String satckTrace;

    public static ScriptExecutionResult success(String result, String output) {
        ScriptExecutionResult ScriptExecutionResult = new ScriptExecutionResult();
        ScriptExecutionResult.setResult(result);
        ScriptExecutionResult.setOutput(output);
        return ScriptExecutionResult;
    }

    public static ScriptExecutionResult error(String satckTrace) {
        ScriptExecutionResult ScriptExecutionResult = new ScriptExecutionResult();
        ScriptExecutionResult.setSatckTrace(satckTrace);
        return ScriptExecutionResult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        if (result == null) {
            this.result = "";
        }
        else {
            this.result = result;
        }
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        if (output == null) {
            this.output = "";
        }
        else {
            this.output = output;
        }
    }

    public String getSatckTrace() {
        return satckTrace;
    }

    public void setSatckTrace(String satckTrace) {
        this.satckTrace = satckTrace;
    }

    @Override
    public String toString() {
        return "ScriptExecutionResult{" +
                "result='" + result + '\'' +
                ", output='" + output + '\'' +
                ", satckTrace='" + satckTrace + '\'' +
                '}';
    }
}
