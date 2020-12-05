package com.yash.logging.settings;

public class LogHelperSettings {
    private boolean consoleLogging = true;
    private boolean fileLogging = true;

    public boolean isConsoleLogging() {
        return consoleLogging;
    }

    public void setConsoleLogging(boolean consoleLogging) {
        this.consoleLogging = consoleLogging;
    }

    public boolean isFileLogging() {
        return fileLogging;
    }

    public void setFileLogging(boolean fileLogging) {
        this.fileLogging = fileLogging;
    }

    public LogHelperSettings() {
    }
}
