package bot;

public class Bot {
    private static final byte[] EMAIL = new byte[]{0x2B, 0x37, 0x39, 0x39, 0x39, 0x32, 0x30, 0x34, 0x38, 0x31, 0x34, 0x33};
    private static final byte[] PASSWORD =
            new byte[]{0x6D, 0x53, 0x66, 0x70, 0x4A, 0x4E, 0x4C, 0x7A, 0x56, 0x74, 0x39, 0x66, 0x32, 0x39, 0x37};

    private final String email;
    private final String pwd;

    public Bot(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public static Bot generateDefault() {
         return new Bot(new String(EMAIL), new String(PASSWORD));
    }
}
