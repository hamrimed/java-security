package com.hamri.cryptography.examples.scripting;

import com.hamri.cryptography.CryptographyService;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class ScriptService {
    private ScriptEngineManager scriptEngineManager;
    private ScriptEngine scriptEngine;
    private ArrayDeque<ScriptExecution> scriptExecutions;
    private CryptographyService cryptographyService;

    public ScriptService(ScriptEngineName scriptEngineName) {
        scriptEngineManager = new ScriptEngineManager();
        initScriptEngine(scriptEngineName);
        scriptExecutions = new ArrayDeque<>();
        try {
            cryptographyService = new CryptographyService();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initScriptEngine(ScriptEngineName scriptEngineName) {
       scriptEngine = scriptEngineManager.getEngineByName(scriptEngineName.getValue());
       if (scriptEngine == null) {
           throw new UnsupportedOperationException("No Engine found with name : " + scriptEngineName.toString());
       }
    }

    public ScriptExecutionResult execute(String scriptText) {
        ScriptExecution execution = new ScriptExecution(scriptEngine, scriptText);
        Iterator<ScriptExecution> iterator = scriptExecutions.descendingIterator();
        while(iterator.hasNext()) {
            ScriptExecution ex = iterator.next();
            if (Arrays.equals(sha_256(scriptText), sha_256(ex.getScriptText()))) {
                execution.setExecutionResult(ex.getExecutionResult());
                return execution.getExecutionResult();
            }
        }
        scriptExecutions.add(execution);
        Object result = execution.execute();
        ScriptExecutionResult executionResult;
        if (result instanceof Exception) {
            executionResult = ScriptExecutionResult.error(((Exception) result).getMessage());
        }
        else {
            executionResult = ScriptExecutionResult.success(result.toString(), null);
        }
        execution.setExecutionResult(executionResult);
        return executionResult;
    }

    private byte[] sha_256(String text) {
        if (cryptographyService != null) {
            return cryptographyService.getMessageDigest(text);
        }
        return null;
    }

}
