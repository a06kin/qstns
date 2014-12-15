package me.aaa.qstns.basis.exceptions;

import me.aaa.qstns.basis.enums.QstnStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED) //#417
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
