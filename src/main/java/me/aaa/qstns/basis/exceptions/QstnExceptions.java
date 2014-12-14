package me.aaa.qstns.basis.exceptions;

import me.aaa.qstns.basis.enums.QstnStatus;

public class QstnExceptions extends Exception {

    private QstnStatus status;

    public QstnExceptions(QstnStatus status, String message) {
        super(message);
        this.status = status;
    }

    public QstnStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return String.format("%s: %s", status, super.getMessage());
    }
}
