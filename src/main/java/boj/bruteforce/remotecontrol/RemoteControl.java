package boj.bruteforce.remotecontrol;

class RemoteControl {
    private static final boolean NORMAL = Boolean.TRUE;
    private static final boolean BROKEN = Boolean.FALSE;

    private final boolean[] remoteControl;

    public RemoteControl(final boolean[] remoteControl) {
        this.remoteControl = remoteControl;
    }

    public boolean canPushButton(int button) {
        if (button == 0) {
            return !remoteControl[button];
        }

        while (button > 0) {
            if (remoteControl[button % 10]) {
                return BROKEN;
            }
            button /= 10;
        }
        return NORMAL;
    }

    public int calculatePushCount(final int button) {
        return String.valueOf(button).length();
    }
}
