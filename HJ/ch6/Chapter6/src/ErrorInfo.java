class Err {
    String msg;   // 에러 메시지
    int severity; // 에러 심각도

    // 생성자
    Err(String m, int s) {
        msg = m;
        severity = s;
    }
}
class ErrorInfo {
    String msgs[] = {
            "Output Error",
            "Input Error",
            "Disk Full",
            "Index Out-Of-Bounds"
    };

    int howbad[] = { 3, 3, 2, 4 };

    // Err 객체 반환
    Err getErrorInfo(int i) {
        if (i >= 0 && i < msgs.length) {
            return new Err(msgs[i], howbad[i]);
        } else {
            return new Err("Invalid Error Code", 0);
        }
    }
}
class ErrInfo {
    public static void main(String[] args) {
        ErrorInfo err = new ErrorInfo();
        Err e;

        e = err.getErrorInfo(2);
        System.out.println(e.msg + " severity: " + e.severity);

        e = err.getErrorInfo(19);
        System.out.println(e.msg + " severity: " + e.severity);
    }
}