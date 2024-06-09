package com.hamri.cryptography.examples.scripting;

public enum ScriptEngineName {
    GROOVY("groovy"),
    JAVASCRIPT("JavaScript"),
    PYTHON("Python"),
    RUBY("Ruby");

    private String value;
    ScriptEngineName(String name) {
        this.value = name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
