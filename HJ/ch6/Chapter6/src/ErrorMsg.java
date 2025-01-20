class ErrorMsg {
    String msg[] = {
            "Output Error",
            "Input Error",
            "Disk Full",
            "Index Out-Of-Bounds"
    };

    String getErrorMsg(int i) {
        if(i >= 0 && i < msg.length) {
            return msg[i];
        } else {
            return "Invalid Error Code";
        }
    }
}